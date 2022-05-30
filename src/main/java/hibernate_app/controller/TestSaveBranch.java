package hibernate_app.controller;

import hibernate_app.dto.Branchdto;
import hibernate_app.service.impl.BranchServiceImpl;

public class TestSaveBranch {

	public static void main(String[] args) {
		Branchdto  branchdto = new Branchdto() ;
		branchdto.setPhone(7532146980l);
		branchdto.setBranchName("appolo gandhi bazaar");
		branchdto.setEmail("bazaar.appolo@mail.com");
		
		BranchServiceImpl branchServiceImpl =  new BranchServiceImpl() ;
		branchServiceImpl.saveBranch(1, branchdto) ;
	}
}
