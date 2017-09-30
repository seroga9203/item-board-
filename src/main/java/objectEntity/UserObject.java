
package objectEntity;



import dao.UserDAO;
import entity.User;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import spring.SpringContextHolder;

public class UserObject {
   private Integer id;
   private String login ;
   private String pass;
   private Date date;
   private String phone;
   private String email;
   private String city;
   private String checkPass;
   private String searchError;
   private boolean searchUser = false;
   private boolean isChecked = false;
   
   private String loginErr;
   private String passwErr;
   private String checkPasswErr;
   private String phoneErr;
   private String emailErr;
   private String cityErr;
   private String identPasswError;
   private String currPasswError;



 //созжание обьекта БД с логином /паролем для идентификации
 public  UserObject(String login){
       if(login!=null){
       this.searchUser =true;
       User user = getUser(login);
       if(user!=null){
           this.id = user.getId();
           this.login = user.getLogin();
           this.pass  = user.getPass();
           this.date  = user.getDate();
           this.phone  = user.getPhone();
           this.pass = user.getPass();
           this.email = user.getEmail();
           this.city = user.getCity();
         }   
       }
       
    }
///создание  с полными данными (для передачи в БД)
    public UserObject(String login, String pass, String checkPass, Date date, String phone, String email, String city) {
        this.login = login;
        this.pass = pass;
        this.date = date;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.checkPass = checkPass;
    }
// геттеры и сеттеры всех полей
    public String getCheckPass() {
        return checkPass;
    }

    public void setCheckPass(String checkPass) {
        this.checkPass = checkPass;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }
     public void appendSearchError(String searchError) {
        this.searchError += searchError;
    }


    public boolean isSearchUser() {
        return searchUser;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return pass;
    }

    public String getSearchError() {
        return searchError;
    }

    public String getLoginErr() {
        return loginErr;
    }

    public void setLoginErr(String loginErr) {
        this.loginErr = loginErr;
    }

    public String getPasswErr() {
        return passwErr;
    }

    public void setPasswErr(String passwErr) {
        this.passwErr = passwErr;
    }

    public String getCheckPasswErr() {
        return checkPasswErr;
    }

    public void setCheckPasswErr(String checkPasswErr) {
        this.checkPasswErr = checkPasswErr;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getCityErr() {
        return cityErr;
    }

    public void setCityErr(String cityErr) {
        this.cityErr = cityErr;
    }

    public String getIdentPasswError() {
        return identPasswError;
    }

    public void setIdentPasswError(String identPasswError) {
        this.identPasswError = identPasswError;
    }

    public boolean isIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getCurrPasswError() {
        return currPasswError;
    }

    public void setCurrPasswError(String currPasswError) {
        this.currPasswError = currPasswError;
    }
    
    ///получаем юзера из БД
    private User getUser(String login){
        UserDAO udao = (UserDAO) SpringContextHolder.getContext().getBean("udao");
        return udao.getUserByLogin(login);
    }
    
    public void setUser(){
        UserDAO udao = (UserDAO) SpringContextHolder.getContext().getBean("udao");
        User u = new User(new Random().nextInt(), this.date, this.login, this.pass, this.phone, this.email, this.city);
        udao.addUser(u);
    }
     public void updateUser(){
        UserDAO udao = (UserDAO) SpringContextHolder.getContext().getBean("udao");
        User u = new User(this.id, this.date, this.login, this.pass, this.phone, this.email, this.city);
        udao.updateUser(u);
    }
    //возвращает коллекцию с текущим классом, нужно для передачи на фронт
     public List<UserObject> getUserList(){
     List<UserObject> user = new LinkedList<>();
     user.add(this);
     return user;
     } 
}

