package pl.jaz.jazapp;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

@WebServlet("average")
public class AverageServlet extends HttpServlet {
    @Inject
    private UserContext userContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



            // http://localhost:8080/app/average?numbers=1,2,3
//   PrintWriter writer = resp.getWriter();
//
//       String numbers = req.getParameter("numbers");
//
//       String[] sNum = numbers.split(",");
//       int s = 0 ;
//
//       for (String n: sNum) {
//            s += Integer.parseInt(n);
//
//       }
//       float avg = (float) s / sNum.length;
//       String avd = new BigDecimal((double) s / sNum.length)
//               .setScale(2 , RoundingMode.HALF_UP)
//               .toString();
//
//
//
//       writer.println("Srednia z podanych parametrow " + numbers +" = " + avg);
//       writer.println("Srednia z podanych parametrow (HALF_UP)" + numbers +" = " + avd);



        resp.setStatus(200);
        resp.setContentType("text/plain");

        userContext.getUserId();
        if (userContext.getUserId() == null){
            userContext.setUserId(new Random().nextLong());
        }

        PrintWriter respWriter = resp.getWriter();
        respWriter.println(String.format("My user ID: %d", userContext.getUserId()));
        }
    }

