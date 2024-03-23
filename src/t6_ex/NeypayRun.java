package t6_ex;

import java.util.Scanner;

public class NeypayRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SalaryService salaryService = new SalaryService();
		InsaService insaService = new InsaService();
		NetpayService service = new NetpayService();
		int choice = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("인사 급여 관리");
			System.out.print("메뉴선택? : 1.본봉테이블관리 2.인사관리 3.급여관리 0.종료 ==>");
			choice = sc.nextInt();
			
		switch (choice) {
			case 1:
				while(true) {
					System.out.println(" 본봉테이블 관리 ");
					System.out.print("1:직급/본봉입력  2:직급/본봉조회  3:본봉수정  4:직급삭제  0:종료 ==> ");
					choice = sc.nextInt();
					if(choice == 1) salaryService.setSalaryInput();
					else if (choice ==2) salaryService.getSalaryList();
					else if (choice ==3) salaryService.getSalaryUpdate();
					else if (choice ==4) salaryService.getSalaryDelete();
					else break;
				}
				break;
			case 2: 
				
				break;
			case 3: 
				
				break;

			default:
				break;
		}	
					
		
			
		}
	}	
}
