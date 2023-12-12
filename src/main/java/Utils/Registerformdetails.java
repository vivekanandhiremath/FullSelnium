package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registerformdetails {
    public static List<Map<String, Object>> getUserDetails() {
        List<Map<String, Object>> userDetailsList = new ArrayList<>();


        Map<String, Object> user1 = new HashMap<>();
        user1.put("firstname", "vivek");
        user1.put("lastname", "hiremath");
        user1.put("email", "vivekanand@gmail.com");
        user1.put("telephone", 666788999);  // Numeric field
        user1.put("password", "vivek");
        user1.put("passwordconfirm", "vivek");
        // Add other fields

        Map<String, Object> user2 = new HashMap<>();
        user2.put("firstname", "John");
        user2.put("lastname", "smith");
        user2.put("email", "smith@gmail.com");
        user2.put("telephone", 466788999);  // Numeric field
        user2.put("password", "smith");
        user2.put("passwordconfirm", "smith");

        userDetailsList.add(user1);
//        userDetailsList.add(user2);

        return userDetailsList;


    }
}

