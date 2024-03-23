package t6_ex;

import java.util.ArrayList;
import java.util.Scanner;

public class SalaryService {
	Scanner sc = new Scanner(System.in);
	NetpayDAO dao = new NetpayDAO();
	NetpayVO vo = null;
	
	String ans ="N";
	//입력
	public void setSalaryInput() {
		System.out.println("본봉테이블 입력처리");
		String jikkub = "";
		
		while(true) {
			System.out.print("직급 : "); jikkub = sc.next();
			vo = dao.getJikkubSearch(jikkub);
			if(vo == null) break;
			else System.out.println("같은 직급 존재 다시 입력");
		}
		vo = new NetpayVO();
		vo.setJikkub(jikkub);
		System.out.println("본봉 : "); vo.setBonbong(sc.nextInt());
		
		int res = dao.setSalaryInput(vo);
		
		if(res != 0) System.out.println("본봉 테이블에 등록");
		else System.out.println("본봉 테이블에 등록 실패");
	}
//본봉 전체 조회
	public void getSalaryList() {
		ArrayList<NetpayVO> vos = dao.getSalaryList();
		System.out.println("본봉 전체 조회");
		System.out.println("번호\t직급\t본봉");
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			System.out.print(" " + (i+1) + "\t");
			System.out.print(vo.getJikkub() + "\t");
			System.out.print(vo.getBonbong() + "\n");
		}
		System.out.println("사람 : " + vos.size() + "명");
	}

	public void getSalaryUpdate() {
		// TODO Auto-generated method stub
		
	}

	public void getSalaryDelete() {
		// TODO Auto-generated method stub
		
	}

}
