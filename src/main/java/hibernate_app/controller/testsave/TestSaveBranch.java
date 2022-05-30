package hibernate_app.controller.testsave;

import hibernate_app.dto.Branchdto;
import hibernate_app.service.impl.BranchServiceImpl;

public class TestSaveBranch {

	public static void main(String[] args) {
		Branchdto  branchdto = new Branchdto() ;
		branchdto.setPhone(7001444676l);
		branchdto.setBranchName("appolo BTM");
		branchdto.setEmail("btm.appolo@mail.com");
		
		BranchServiceImpl branchServiceImpl =  new BranchServiceImpl() ;
		branchServiceImpl.saveBranch(1, branchdto) ;
	}
}
