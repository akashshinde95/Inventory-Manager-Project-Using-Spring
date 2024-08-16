package com.akash.controller;

import javax.imageio.metadata.IIOInvalidTreeException;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.akash.Dao.IssueProDao;
import com.akash.Dao.IssueRawDao;
import com.akash.Dao.ManagerDao;
import com.akash.Dao.ProcessMateDao;
import com.akash.Dao.RawDao;
import com.akash.RawMaterial.IssueProMat;
import com.akash.RawMaterial.IssueRawMat;
import com.akash.RawMaterial.Manager;
import com.akash.RawMaterial.ProcessMaterial;
import com.akash.RawMaterial.RawMaterial;
import java.util.List;



@Controller
public class MainController {
	
	
	private ManagerDao managerDao;

	@RequestMapping("/")
	public String OpenIndexPage(){
		
		System.out.println("Opening Index page...");
		return "index";	
	}
	
	@RequestMapping(path="/loginAdmin", method = RequestMethod.POST)
	public String AdminLogin(HttpServletRequest request, Model model)
	{
		String cemail = request.getParameter("cemail");
		String cpass = request.getParameter("cpass");
		System.out.println(cemail);
		System.out.println(cemail);
		if(cemail.equals("akash@gmail.com")&& cpass.equals("admin")){
			model.addAttribute("em",cemail);
			return "home";
		}
		else{
			return "index";
		}
	}
	
	
	//Change Password ************************
	
	@RequestMapping("/changeP")
    public String openChangePPage() {
        return "ChangePass";
    }

    @RequestMapping(path="/changePassword", method=RequestMethod.POST)
    public String changepass(HttpServletRequest request, Model model) {
        String cemail = request.getParameter("cemail");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        Manager manager = managerDao.getInfo(cemail);
        
        if (manager != null && manager.getCpasword().equals(currentPassword)) {
            if (newPassword.equals(confirmPassword)) {
                manager.setCpasword(newPassword);
                managerDao.updatePassword(manager);
                return "home";
            } else {
                model.addAttribute("error", "New passwords do not match.");
                return "ChangePass";
            }
        } else {
            model.addAttribute("error", "Current password is incorrect.");
            return "ChangePass";
        }
    }

	
	
	
			@RequestMapping("/welcomeRaw")
			public String openRawPage()
			{
				return "RawHome";
			}
			
			
			//Processed Item welcome
			@RequestMapping("/welcomePr")
			public String openProcessedPage()
			{
				return "ProHome";
			}
			

	


/*Raw Material Operations(********************************************************************************	
*****************************************************************************************************************/	
		

	
	@Autowired
	RawMaterial rawMaterial;
	@Autowired
	RawDao rawDao;
	
	@RequestMapping("/ADD_RawMate")
	public String OpenAddMaterialPage(){
		
		System.out.println("Opening Add Material page...");
		return "A01_Add_RawMaterial";	
	}
	
	
	@RequestMapping(path="/ADD_NewRawMaterial", method = RequestMethod.POST)
	public String OpenAddMaterial(@ModelAttribute RawMaterial rawMaterial, HttpServletRequest request)
	{
		int i = rawDao.addRawMaterial(rawMaterial);
		System.out.println("Opening Add Material page...");
		return "RawHome";	
	}
	
	
	@RequestMapping("/View_RawMate")
	public String OpenViewMaterialsPage(Model model){
		
		List<RawMaterial> rawMaterial = rawDao.getAllRawMaterial();
		model.addAttribute("rawMaterialList", rawMaterial);
		return "A02_View_RawMaterial";	
	}
	
	
	@RequestMapping(value = "/delraw", method = RequestMethod.POST)
    public String deleteRaw(@RequestParam("rawId") int rawId, Model model)
	{
        rawDao.deleteRawMaterial(rawId);
        return "RawHome";
    }
	
	@RequestMapping("/updateM")
	public String openUpdatePage()
	{
		return "update";
	}
	
	@RequestMapping("/updateRM")
	public String openUpdateRawPage()
	{
		return "A04_Update_RawMaterial";
	}
	
	@RequestMapping(path="/updateraw", method=RequestMethod.POST)
	public String updateRawMaterial(@ModelAttribute RawMaterial rawMaterial, HttpServletRequest request)
	{
		int rid = Integer.parseInt(request.getParameter("rawId"));
		int addquantity = Integer.parseInt(request.getParameter("addrawQuantity"));
		
		rawDao.updateRaw(rid, addquantity);
		return "RawHome";
	}
	

	
	
	
    //Show Unavailable RAw Material
		@RequestMapping("/showUnavRaw")
	    public String showUnavailableRawMaterials(Model model) 
		{
	        List<RawMaterial> rawMaterials = rawDao.getAllUnavailableRawMaterials();
	        model.addAttribute("unavRawList", rawMaterials);
	        return "A07_Show_UnRaw";
	    }

	

	
/*Issue Raw Material Operations (************************************************************************************************************
 ******************************************************************************************************************************************** 
 */
		
			
		@Autowired
		IssueRawMat issueRawMat;
		@Autowired
		IssueRawDao issueRawDao;
		
		
		@RequestMapping("/issRaw")
	    public String openIssueRawMaterialPage() 
		{
	        return "A05_Add_IssueRaw";
	    }
		
		/*@RequestMapping(path="/issraw", method=RequestMethod.POST)
		public String openIssueNewPage(@ModelAttribute IssueRawMat issueRawMat, HttpServletRequest request)
		{
			int i= issueRawDao.addIssueRawMat(issueRawMat);
			return "RawHome";
		}                        *****  modified here  *****                  */
		
		
		@RequestMapping(path="/issraw", method=RequestMethod.POST)
		public String issueRawMaterial(@ModelAttribute IssueRawMat issueRawMat, HttpServletRequest request, Model model) {
		    int rawId = issueRawMat.getRawId();						/* Id is taken from IssueRawMat */
		    float issueQuantity = issueRawMat.getiRawquantity();   /*flaot is taken as int */
		    
		    // Update raw material quantity
		    RawMaterial rawMaterial = rawDao.getRawMaterial(rawId);
		    if (rawMaterial != null) {
		        int newQuantity = (int) (rawMaterial.getRawQuantity() - issueQuantity);  /*(int) cast isadded*/
		        rawMaterial.setRawQuantity(newQuantity);
		        
		        // If the new quantity is zero or less, mark it as unavailable
		        if (newQuantity <= 0) {
		            rawMaterial.setRawQuantity(0);
		        }
		        rawDao.updateRawMaterial(rawMaterial);
		    }

		    // Add issue record
		    issueRawDao.addIssueRawMat(issueRawMat);
		    return "RawHome";
		}

		
		@RequestMapping("/View_Rawissue")
		public String openViewIssueRaw(Model model)
		{
		 	List<IssueRawMat> issueRawMats = issueRawDao.getAllIssueRawMat();
			model.addAttribute("issueRawMatList",issueRawMats);
			return "A06_View_IssueRaw";
		}
	 
		
		 @RequestMapping(value = "/delIssueRaw", method = RequestMethod.POST)
		    public String deleteIssueRaw(@RequestParam("iId") int iId, Model model)
		 {
		        issueRawDao.deleteIssueRawMat(iId);
		        return "RawHome";
		 }

		 
		 
			 
			 
		
		 
	 
	
	
/*Processed Material Operations (********************************************************************************	
*****************************************************************************************************************/	
	
	
	@Autowired
	ProcessMaterial processMaterial;
	@Autowired
	ProcessMateDao processMateDao;

	@RequestMapping("/ADD_ProMate")
	public String OpenAddProcessMatePage(){
		
		System.out.println("Opening Add Material page...");
		return "Z01_Add_ProMaterial";	
	}
	
	@RequestMapping(path="/ADD_NewProcessMaterial", method = RequestMethod.POST)
	public String OpenAddProMaterial(@ModelAttribute ProcessMaterial processMaterial, HttpServletRequest request)
	{
		int i = processMateDao.addProcessMate(processMaterial);
		System.out.println("Opening Add New Process Material page...");
		return "ProHome";	
	}
	
	@RequestMapping("/View_ProssMate")
	public String OpenViewProcessMaterialsPage(Model model){
		
		List<ProcessMaterial> processMaterial = processMateDao.getAllProcessMaterial();
		model.addAttribute("processMaterialList", processMaterial);
		return "Z02_View_ProMaterial";	
	}
	
	@RequestMapping(value = "/delPro", method = RequestMethod.POST)
    public String deleteProcessMate(@RequestParam("ProMatId") int ProMatId, Model model)
	{
        processMateDao.deleteProcessMate(ProMatId);
        return "ProHome";
    }
	
	
	@RequestMapping("/uppro")
	public String openUpdateProPage()
	{
		return "Z04_Update_ProMaterial";
	}
	
	@RequestMapping(path="/updatepro", method=RequestMethod.POST)
	public String updateProMaterial(@ModelAttribute ProcessMaterial processMaterial, HttpServletRequest request)
	{
		int rid = Integer.parseInt(request.getParameter("ProMatId"));
		int addquantity = Integer.parseInt(request.getParameter("addproQuantity"));
		
		processMateDao.updateproMaterial(rid, addquantity);
		return "ProHome";
	}
	
	@RequestMapping("/showUnavPro")
	public String showUnavailableProMaterials(Model model) 
	{
	    List<ProcessMaterial> processMaterials = processMateDao.getAllUnavailableProMaterials();
	    model.addAttribute("unavProList", processMaterials);
	    return "Z07_Show_UnPro";
	}
	 
	 
	
	
/*Issue Process Material Operations (************************************************************************************************************
 ******************************************************************************************************************************************** 
 */	

	
	@Autowired
	IssueProMat issueProMat;
	@Autowired
	IssueProDao issueProDao;
	
	
	@RequestMapping("/issPro")
    public String openIssueProMatPage() 
	{
        return "Z05_Add_IssuePro";
    }
	
	@RequestMapping(path="/addisspro", method=RequestMethod.POST)
	public String openIssueProPage(@ModelAttribute IssueProMat issueProMat, HttpServletRequest request) {
	    int i = issueProDao.addIssueProMat(issueProMat);
	    return "ProHome";
	}

	@RequestMapping(path="/isspro", method=RequestMethod.POST)
	public String issueProMaterial(@ModelAttribute IssueProMat issueProMat, HttpServletRequest request, Model model) {
	    int pId = issueProMat.getpId();
	    float issueQuantity = issueProMat.getpProquantity();
	    
	    // Update raw material quantity
	    ProcessMaterial processMaterial = processMateDao.getProcessMaterial(pId);
	    if (processMaterial != null) {
	        int newQuantity = (int) (processMaterial.getProMatQuantity() - issueQuantity);
	        if (newQuantity <= 0) {
	            processMaterial.setProMatQuantity(0);
	        } else {
	            processMaterial.setProMatQuantity(newQuantity);
	        }
	        processMateDao.updateProcessMaterial(processMaterial);
	    }

	    // Add issue record
	    issueProDao.addIssueProMat(issueProMat);
	    return "ProHome";
	} 
	
	
	
/*coded*/
	@RequestMapping("/View_IssuePro")
	public String OpenViewIssProMate(Model model){
		
		List<IssueProMat> issueProMats = issueProDao.getAllIssueProMat();
		model.addAttribute("issueProMatList", issueProMats);
		return "Z06_View_IssuePro";	
	}
	
	 @RequestMapping(value = "/delIssuePro", method = RequestMethod.POST)
	    public String deleteIssuePro(@RequestParam("pId") int pId, Model model)
	 {
	        issueProDao.deleteIssueProMat(pId);
	        return "ProHome";
	 }               
}







