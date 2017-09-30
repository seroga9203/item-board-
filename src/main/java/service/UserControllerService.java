package service;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objectEntity.UserObject;
import org.springframework.web.servlet.ModelAndView;

public class UserControllerService {

    //private boolean firstEnter = true;
    public UserObject checkUserPassw(String login, String pass) {
        //HttpSession s = req.getSession();
        //метод для поиска пользователя по логину/паролюю возвращает или вью логирования или мейн
        ModelAndView mv;
        //получаем пользователя
        UserObject uo = new UserObject(login);
        String uoLogin = uo.getLogin();
        String uoPass = uo.getPassword();
        boolean uoSearchUser = uo.isSearchUser();

        if (uoLogin == null && uoSearchUser == true) {
            //если нет пользователя по логину - проставляем в сессию атрибут логин еррор, который будут отображен на странице
            uo.setSearchError("Unexist user. Please, try again or register");
            uo.setIsChecked(false);
        } else if (uoLogin == null) {
            //первая загрузка
            uo.setIsChecked(false);
        } else if (uoLogin != null && !uoPass.equals(pass)) {
            //если некорректный пароль - проставляем в сессию атрибут логин еррор, который будут отображен на странице
            uo.setSearchError("Uncorrect password. Please, try again");
        } else {
            //если все корректно - на страницу мейн с засечиванием аттрибутов сессии
            uo.setIsChecked(true);
        }

        return uo;
    }

    public UserObject registerUser(String login, String pass, String checkPass, Date date, String phone, String email, String city) {

        ModelAndView mv;
        UserObject uo = new UserObject(login, pass, checkPass, date, phone, email, city);
        ////////////////сдесь проверка логина
        boolean isCorrectLogin = false;
        boolean isCorrectPass = false;
        boolean isCorrectCity = false;
        boolean isCorrectPhone = false;
        boolean isCorrectMail = false;
        //проверяем пустые поля

        String logErr = getLoginError(login);
        if (logErr != "") {
            uo.setLoginErr(logErr);
        } else if (login != "" && login != null) {
            isCorrectLogin = true;
        }

        String passwErr = getPasswError(pass, checkPass);
        if (passwErr != "") {
            uo.setPasswErr(passwErr);
        } else if (pass != "" && pass != null && pass != null && pass != "") {
            isCorrectPass = true;
        }

        String cityErr = getCityError(city);
        if (cityErr != "") {
            uo.setCityErr(cityErr);

        } else if (city != "" && city != null) {
            isCorrectCity = true;
        }

        String phoneErr = getProneError(phone);
        if (phoneErr != "") {
            uo.setPhoneErr(phoneErr);
        } else if (phone != "" && phone != null) {
            isCorrectPhone = true;
        }

        String emailErr = getEmailError(email);
        if (emailErr != "") {
            uo.setEmailErr(emailErr);
        } else if (email != "" && email != null) {
            isCorrectMail = true;
        }

        //переходы
        if (isCorrectMail && isCorrectPhone && isCorrectCity && isCorrectPass && isCorrectLogin) {
            uo.setIsChecked(true);
        }

        return uo;
    }

    public UserObject changeUser(String currLogin, String currPass, String pass, String checkPass, String phone, String email, String city) {
        //ф-ция для измнений данных пользователя

        UserObject uo = new UserObject(currLogin);
        
        boolean phoneUpd = false;
        String phoneErr = "";

        boolean emailUpd = false;
        String emailErr = "";

        boolean cityUpd = false;
        String cityErr = "";

        boolean IsCurrPass = false;
        boolean passwUpd = false;
        String passwErr = "";

        if (currPass != null && currPass != "") {
            if (currPass.equals(uo.getPassword())) {
                IsCurrPass = true;
            } else {
                uo.setCurrPasswError("Uncorrect current password");
            }
        } else {
            uo.setIdentPasswError("For change your profile, enter your password");
        }
        
        //пароль проверяем только если был введен новый
        if(pass != null && pass!= ""){
             passwErr = getPasswError(pass, checkPass);
            if(!passwErr.equals("")){
                uo.setPasswErr(passwErr);
            }
            else{
            uo.setPass(pass);
            passwUpd = true;
            }
        }
        phoneErr = getProneError(phone);
        
        if (phoneErr != "") {
            //если не прошли проверку, засечиваем ошибку и выставляем флаг апдейта в фолс
            uo.setPhoneErr(phoneErr);
            //phoneUpd = false;
        }
        else if(phone != null && phone != "") {
            String uoPhone = uo.getPhone();
            if (!uoPhone.equals(phone)) {
                //если новый телефон отличается от старого, проводим проверку и вставляем новое значение в касс
                uo.setPhone(phone);
                phoneUpd = true; //если отлиаются телефоны  - взводим флаг апдейта телефонов
            }
        }
       
        emailErr = getEmailError(email);
       
        if (emailErr != "") {
            //если не прошли проверку, засечиваем ошибку и выставляем флаг апдейта в фолс
            uo.setEmailErr(emailErr);
            //emailUpd = false;
        } else if (email != null && email != "") {
            String uoEmail = uo.getEmail();
            if (!uoEmail.equals(email)) {
                //если новый email отличается от старого, проводим проверку и вставляем новое значение в касс
                uo.setEmail(email);
                emailErr = getEmailError(email);
                emailUpd = true; //если отлиаются email  - взводим флаг апдейта email

            }
        }
        cityErr = getCityError(city);
        if (cityErr != "") {
            //если не прошли проверку, засечиваем ошибку и выставляем флаг апдейта в фолс
            uo.setCityErr(cityErr);
            //cityUpd = false;
        } else if (city != null && city != "") {
            String uoCity = uo.getCity();
            if (!uoCity.equals(city)) {
                //если новый city отличается от старого, проводим проверку и вставляем новое значение в касс
                uo.setCity(city);
                cityUpd = true; //если отлиаются city  - взводим флаг апдейта city
            }
        }

        //переходы
        if ((phoneUpd || cityUpd || emailUpd|| passwUpd ) && phoneErr.equals("") && emailErr.equals("") && cityErr.equals("") && IsCurrPass && passwErr.equals("") ) {

            uo.setIsChecked(true);
        }
        return uo;
    }

    private boolean checkPass(String pass, String checkPass) {

        boolean identical = false;
        if (pass.equals(checkPass)) {
            identical = true;
        }
        return identical;
    }

    private boolean checkPhone(String phone) {
        boolean isCorrect = false;

        if (phone.length() == 13 && phone.substring(0, 4).equals("+380")) {
            isCorrect = true;
        }
        return isCorrect;
    }

    private boolean checkEmail(String email) {
        // boolean isCorrect = false;
        int at = email.indexOf("@");
        if (at < 3) {
            //если до собачки меньше 4-х символов
            return false;
        }

        if (email.substring(at, at).equals(".")) {
            //если после собачки сразу точнка
            return false;
        }

        if (email.contains(",") || email.contains("/") || email.contains("?")) {
            //наличие запрещенных Верховной инквизицией символов
            return false;
        }

        return true;
    }

    private String getLoginError(String login) {
        if (login == "") {
            return "Field login is required";
        } else if (login != null) {
            UserObject uo2 = new UserObject(login);
            if (uo2.getLogin() != null) {
                return "Exist login";
            }
        }
        return "";
    }

    private String getPasswError(String pass, String checkPass) {
        if (pass == "") {
            return "Field password is required";
        }
        if (checkPass == "") {
            return "Field CheckPassword is required";

        } else if (checkPass != null && pass != "" && pass != null && !pass.equals(checkPass)) {
            return "Fields password and checkPasw must be identical";
        }
        return "";
    }

    private String getCityError(String city) {
        if (city == "") {
            return "Field city is required";
        }
        return "";
    }

    private String getProneError(String phone) {
        if (phone == "") {
            return "Field phone is required";
        } else if (phone != null) {
            if (!checkPhone(phone)) {
                return "Phone must be like +380XXXXXXXXX";
            }
        }
        return "";
    }

    private String getEmailError(String email) {
        if (email == "") {
            return "Field email is required";
        }
        /*if (email.length() > 0) {
                if (!checkEmail(email)) {
                    uo.setEmailErr("Email must be like test@domain.namespase");
                    isCorrect = false;
                }
            }*/
        return "";
    }
}
