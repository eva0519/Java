package ex1;

import java.sql.SQLException;

import com.evagrim.app.console.NoticeConsole;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		NoticeConsole console = new NoticeConsole();
		
		EXIT:
		while (true) {
			
			console.printNoticeList();
			
			int menu = console.inputNoticeMenu();
			
			switch (menu) {
			case 1: // 상세조회
				break;
			case 2: // 이전
				console.movePrevList();
				break;
			case 3: // 다음
				console.moveNextList();
				break;
			case 4: // 글쓰기
				break;
			case 5: // 검색
				console.inputSearchWord();
				break;
			case 6: // 종료
				System.out.println("Bye");
				break EXIT;
			default:
				System.out.println("<<사용방법>> 1~5의 숫자만 입력가능합니다");
				break;
			}
			
		}

	}

}
