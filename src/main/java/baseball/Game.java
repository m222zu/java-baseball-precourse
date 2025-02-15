package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    ArrayList<Integer> arrNum = new ArrayList<Integer>();

    public void randomNumber() {
        arrNum.clear();
        while (arrNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!arrNum.contains(randomNumber)) {
                arrNum.add(randomNumber);
            }
        }
        System.out.println("" + arrNum.get(0) + arrNum.get(1) + arrNum.get(2));
    }

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        validateNumber(input);
        return input;
    }

    public void calculateNumber(String input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int inputResult = Character.getNumericValue(input.charAt(i));
            if (inputResult == arrNum.get(i)) {
                strike++;
            } else if (arrNum.contains(inputResult)) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크 ");
        }

        if (strike == 3) {
            restartGame();
        }
    }

    public void validateNumber(String input) {
        if (input.length() != 3 || input.contains("0")) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

    }

    public void restartGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartInput = Console.readLine();

        if (restartInput.equals("1")) {
            play();
        } else if (restartInput.equals("2")) {
            System.exit(0);
        }

    }

    public void play() {
        randomNumber();
        while(true) {
            String input = getUserInput();
            calculateNumber(input);
        }
    }
}





