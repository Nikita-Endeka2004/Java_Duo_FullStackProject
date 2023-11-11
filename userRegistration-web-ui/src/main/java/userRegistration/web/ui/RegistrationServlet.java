package userRegistration.web.ui;


import userRegistration.domain.dto.AppUserCreateDto;
import userRegistration.domain.dto.AppUserViewDto;
import userRegistration.services.UserServiceImpl;
import userRegistration.services_api.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/registrationServlet")
public class RegistrationServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        AppUserCreateDto appUserCreateDto = extractUserFromRequest(req);
        AppUserViewDto user = userService.registerUser(appUserCreateDto);
        req.getSession().setAttribute("user",user);
        resp.sendRedirect("/userRegistration/index");
    }
    private AppUserCreateDto extractUserFromRequest(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String gender = req.getParameter("gender");

        return new AppUserCreateDto(name, surname, gender,email, password);
    }
}
