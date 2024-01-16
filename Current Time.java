import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class CityTimeInfo {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter the name of the city: ");
        String userCityInput = inputScanner.nextLine();

        LocalDateTime currentTimeInCity = LocalDateTime.now(ZoneId.of(userCityInput));

        System.out.println("Current time in " + userCityInput + ": " + currentTimeInCity);

        inputScanner.close();
      
    }
}
