package miniProject;

import java.util.Scanner;

public class MainProcess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controller ct = new Controller();

        int menu = 0;

        while(true) {   // 무한 LOOP

            ct.mainMenu();  // 메뉴 출력
            System.out.println();
            System.out.print("메뉴 선택 : ");
            menu = sc.nextInt();
            System.out.println();

            if(menu == 1) {  // 1. 회원가입 및 계좌연동
                ct.makeMember();

            }else if(menu == 2) {  // 2. 입출금
                ct.moneyinout();

            }else if(menu == 3) {   // 3. 코인정보확인
                ct.infoCoinMenu();

            }else if(menu == 4) {   // 4. 코인시세확인
                ct.checkValue();

            }else if(menu == 5) {  // 5. 코인 매수, 매도
                ct.buyandsell();

            }else if(menu == 6) {    // 6. 투자 내역 확인
                ct.showInvest();

            }else if(menu == 7) {   // 7. 종료
                System.out.println("== 프로그램 종료 ==");
                System.out.println("\n다음 기회에 또 가즈아!");

                System.exit(0);

            }else {
                System.out.println("메뉴의 선택이 올바르지 않습니다.");
                System.out.println();

            }

        }

    }

}
