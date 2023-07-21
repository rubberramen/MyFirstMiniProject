package miniProject;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    // 멤버 필드
    Member member;
    Scanner sc = new Scanner(System.in);

    Coin bitcoin = new Coin();    // 비트코인 생성
    Coin ethereum = new Coin();    // 이더리움 생성
    Coin dogecoin = new Coin();    // 도지코인 생성

    // 생성자 메서드 생략

    // 멤버 메서드

    // 0. 첫메뉴 보여주는 메서드
    public void mainMenu() {  // 화면에 보여줄 메뉴를 출력하는 메서드  # MainProcess class에서 활용
        System.out.println();
        System.out.println("==== 곧 죽어도 코인(feat. 가즈아!) ====");
        System.out.println("-그닥 신뢰하기 어려운 디지털 자산 거래소-");
        System.out.println();
        System.out.println("1. 회원가입 및 계좌연동");
        System.out.println("2. 입출금");
        System.out.println("3. 코인 정보 확인");
        System.out.println("4. 코인 시세 확인");
        System.out.println("5. 코인 매수, 매도");
        System.out.println("6. 투자 내역 확인");
        System.out.println("7. 프로그램 종료");
    }


    // 1. 회원가입 및 계좌연동    # MainProcess class에서 활용
    public void makeMember() {
        String name, accountNumber;
        int balance;

        System.out.println("== 회원가입 ==");
        System.out.print("이름 : ");
        name = sc.nextLine();
        System.out.print("계좌번호 : ");
        accountNumber = sc.nextLine();    // 문자열...
        System.out.print("잔액 기입(원) : ");
        balance = sc.nextInt();

        member = new Member(name, accountNumber, balance);
        System.out.println();
        System.out.println("축하드립니다!\n'곧 죽어도 코인'에 가입되셨습니다.");
        System.out.printf("계좌 잔액(%d원)으로 자유롭게 투자하실 수 있습니다.\n", balance);
        System.out.println();
        System.out.println("투자금액이 부족하다면 입금하시고, 수익을 얻었으면 출금하세요.");
        System.out.println();
        System.out.println();
    }

    // 2. 입출금
    // 2-0. 입출금 메뉴
    public void moneyinout() {

        System.out.println("1. 입금");
        System.out.println("2. 출금");

        System.out.println();

        while(true) {

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            if(menu == 1) {
                member.inMoney();
                break;
            }else if(menu == 2){
                member.outMoney();
                break;
            }else {
                System.out.println("메뉴의 선택이 올바르지 않습니다.");
                System.out.println();
            }
        }
    }

    // 3. 코인 정보 확인 메서드
    // 3-0. 코인 정보 확인 메뉴
    // 선택 시, 각 코인의 간략한 설명 출력과 백서 인터넷 웹 페이지로 이동.
    public void infoCoinMenu() {
        while(true) {
            System.out.println("== 코인 정보(백서) ==");
            System.out.println();
            System.out.println("1. 비트코인");
            System.out.println("2. 이더리움");
            System.out.println("3. 도지코인");
            System.out.println("4. 메인 메뉴로");

            System.out.println();

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            if(menu == 1) {
                this.infoBitcoin();
            }else if(menu == 2){
                this.infoEthereum();
            }else if(menu == 3) {
                this.infoDogecoin();
            }else if(menu == 4) {
                break;
            }else {
                System.out.println("메뉴의 선택이 올바르지 않습니다.");
                System.out.println();
            }
        }
    }

    // 3-1. 비트코인 간략 설명, 백서 웹페이지
    public void infoBitcoin() {
        System.out.println("\n비트코인 : 명실상부 코인의 대명사!\n");
        try {
            Desktop.getDesktop().browse(new URI("https://bitcoin.org/bitcoin.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    // 3-2. 이더리움 간략 설명, 백서 웹페이지

    public void infoEthereum() {
        System.out.println("\n이더리움 : 블록체인 2.0 스마트계약!\n");
        try {
            Desktop.getDesktop().browse(new URI("https://ethereum.org/en/whitepaper/"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    // 3-3. 도지코인 간략 설명, 백서 웹페이지
    public void infoDogecoin() {
        System.out.println("\n도지코인 : 멍멍!!! 일론머스크 x새끼ㅜㅠ\n");
        try {
            Desktop.getDesktop().browse(new URI("https://coinnws.com/dogecoin-whitepaper/"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    // 4. 코인 시세 확인 메서드     // Coin class에서 만든 수시 가격 랜덤 메서드 활용
    public void checkValue() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 mm분 ss초");
        Date now = new Date();
        System.out.println("현재 시간 : " + format.format(now));
        System.out.println();
        System.out.printf("비트코인 1코인 현재 가격 = %d\n", bitcoin.randomprice());    // 메서드 실행할 때마다 가격이 바뀌도록
        System.out.printf("이더리움 1코인 현재 가격 = %d\n", ethereum.randomprice());
        System.out.printf("도지코인 1코인 현재 가격 = %d\n", dogecoin.randomprice());
    }

    // 5. 코인 매수, 매도 메서드    // 아쉬운 점 : 로직이 같은데, 비트코인, 이더리움, 도지코인 따로 작성... ㅜㅠ
    public void buyandsell() {

        System.out.println("1. 비트코인");
        System.out.println("2. 이더리움");
        System.out.println("3. 도지코인");

        System.out.println();

        while(true) {

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            if(menu == 1) {  // 비트코인
                System.out.println();
                System.out.println("1. 비트코인 매수");
                System.out.println("2. 비트코인 매도");
                System.out.println("3. 메인 메뉴로");
                System.out.println();


                System.out.print("메뉴 선택 : ");
                int menu1 = sc.nextInt();

                if(menu1 == 1) {   // 비트코인 매수
                    bitcoin.randomprice();   // 가격 랜덤
                    System.out.print("수량 : ");
                    int amount1 = sc.nextInt();
                    member.buyBitcoin(bitcoin, amount1);

                }else if(menu1 == 2) {   // 비트코인 매도
                    bitcoin.randomprice();   // 가격 랜덤
                    System.out.print("수량 : ");
                    int amount = sc.nextInt();
                    member.sellBitcoin(bitcoin, amount);

                }else if(menu1 == 3) {
                    break;
                }else {
                    System.out.println("메뉴의 선택이 올바르지 않습니다.");
                    System.out.println();
                }
                break;
            }else if(menu == 2){  // 이더리움
                System.out.println();
                System.out.println("1. 이더리움 매수");
                System.out.println("2. 이더리움 매도");
                System.out.println("3. 메인 메뉴로");
                System.out.println();

                System.out.print("메뉴 선택 : ");
                int menu1 = sc.nextInt();

                if(menu1 == 1) {   // 이더리움 매수
                    ethereum.randomprice();
                    System.out.print("수량 : ");
                    int amount = sc.nextInt();
                    member.buyEthereum(ethereum, amount);

                }else if(menu1 == 2) {   // 이더리움 매도
                    ethereum.randomprice();
                    System.out.print("수량 : ");
                    int amount = sc.nextInt();
                    member.sellEthereum(ethereum, amount);

                }else if(menu1 == 3) {
                    break;
                }else {
                    System.out.println("메뉴의 선택이 올바르지 않습니다.");
                    System.out.println();
                }
                break;
            }else if(menu == 3) {  // 도지코인
                System.out.println();
                System.out.println("1. 도지코인 매수");
                System.out.println("2. 도지코인 매도");
                System.out.println("3. 메인 메뉴로");
                System.out.println();

                System.out.print("메뉴 선택 : ");
                int menu1 = sc.nextInt();

                if(menu1 == 1) {   // 도지코인 매수
                    dogecoin.randomprice();
                    System.out.print("수량 : ");
                    int amount = sc.nextInt();
                    member.buyDogecoin(dogecoin, amount);

                }else if(menu1 == 2) {   // 도지코인 매도
                    dogecoin.randomprice();
                    System.out.print("수량 : ");
                    int amount = sc.nextInt();
                    member.sellDogecoin(dogecoin, amount);

                }else if(menu1 == 3) {
                    break;
                }else {
                    System.out.println("메뉴의 선택이 올바르지 않습니다.");
                    System.out.println();
                }
                break;
            }else {
                System.out.println("메뉴의 선택이 올바르지 않습니다.");
                System.out.println();
            }

        }
    } // buyandsell method

    // 6. 투자 내역 확인     // Member class의 '투자 내역 보여주기' 메서드 활용
    public void showInvest() {
        bitcoin.randomprice();   // 메서드 실행할 때마다 가격이 바뀌도록 : 수시로 바뀌는 랜덤 가격을 더 지혜롭게 만들 수 없을까???
        ethereum.randomprice();
        dogecoin.randomprice();

        member.show(bitcoin, ethereum, dogecoin);

    }
}