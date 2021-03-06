package com.greenfox.integrationtesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  @Autowired
  Cargo cargo;
  @Autowired
  Drax drax;

  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Error GrootErrorMessage(MissingServletRequestParameterException e) {
    if (e.getParameterName().equals("message")) {
      return new GrootError("I am Groot");
    } else {
      return new YonduError("Incorrect parameters given");
    }
  }

  @GetMapping("/groot")
  public Groot grootMessage(@RequestParam String message) {
    return new Groot(message);
  }

  @GetMapping("/yondu")
  public Yondu calculateSpeed(@RequestParam float distance, @RequestParam float time) {
    return new Yondu(distance, time);
  }

  @GetMapping("/rocket")
  public Cargo getCargoStatus() {
    return cargo;
  }

  @GetMapping("/rocket/fill")
  public FillCargo fillWithRockets(@RequestParam String caliber, @RequestParam int amount) {
    cargo.fillWithAmmo(caliber, amount);
    cargo.setAmountandStatus();
    return new FillCargo(caliber, amount, cargo.getShipstatus(), cargo.isReady());
  }

  @GetMapping("/drax")
  public Drax listCalories() {
    return drax;
  }

  @GetMapping("/drax/add")
  public Drax addFood(@RequestParam String foodName, @RequestParam int amount, @RequestParam int calories) {
    DraxFood food = new DraxFood(foodName, amount, calories);
    drax.addToFoodList(food);
    return drax;
  }

  @GetMapping("/drax/remove")
  public Drax removeFood(@RequestParam String foodName, @RequestParam int amount){
    drax.removeItem(foodName, amount);
    return drax;
  }
}
