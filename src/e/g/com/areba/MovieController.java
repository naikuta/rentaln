package e.g.com.areba;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/violet")
public class MovieController {
    //DI via Springあいうえお
    String message;

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    //public String getMovie(@PathVariable String name, ModelMap model) {
    public void getMovie(HttpServletResponse response) {

        //model.addAttribute("movie", name);
        //model.addAttribute("message", this.message);

        //return to jsp page, configured in mvc-dispatcher-servlet.xml, view resolver
        //return "list";

        //文字コードと出力するCSVファイル名を設定
        response.setContentType("text/csv" + ";charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"test.csv\"");

        try {
        	PrintWriter pw = response.getWriter();
            //CSVファイル内部に記載する形式で文字列を設定
            String outputString = "id" + "," + "name" + "," + "email" + "," + "password" + "," + "address" + "," + "telephone"
                     + "\r\n";

            //CSVファイルに書き込み
            pw.print(outputString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
