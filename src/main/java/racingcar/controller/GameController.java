package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final CarController carController = new CarController();
    private final RaceController raceController = new RaceController();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void race(List<Car> racingCars) {
        for (Car car : racingCars) {
            raceController.addRecord(car);
        }
    }

    public void proceed() {
        List<Car> racingCars = carController.getRacingCars();
        StringBuilder result = new StringBuilder();

        int count = inputView.getCountInput();
        for (int i = 0; i < count; i++) {
            race(racingCars);

            result.append(raceController.getNameAndRecord(racingCars)).append("\n");
        }
        outputView.printNameAndRecord(result.toString());
    }
}
