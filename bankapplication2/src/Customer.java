
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public  class Customer extends Bank {
    private String name, address, panNo,mobileNo;
    private String adharNo,dateOfBirth,password;
   private boolean temp3=false,temp1=false,temp2=false,temp4=false;
    Scanner in = new Scanner(System.in);

    protected   void setName(String name)
    {
        this.name=name;

    }

    protected void setAddress(String address1,String address2,String adress3) {
        this.address = address1 + "  " +address2+"  "+adress3;
    }

    protected void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    protected void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    protected void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    protected String getMobileNo()
    {
        return mobileNo;
    }

    protected void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    protected String getName() {
        return name;
    }

    protected String getAddress() {
        return address;
    }

    protected String getPanNo() {
        return panNo;
    }

    protected String getAdharNo() {
        return adharNo;
    }

    protected String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean doesPasswordEqual(String password) {
        return this.password.equals(password);
    }

    public String getPassword() {
        return password;
    }

    public void validatePassword() {
        System.out.println("enter the new password");
        String password = in.next();
        setPassword(password);

        }


    protected void validteName() {
        do {
            System.out.println("Enter the name");
            Pattern pattern = Pattern.compile("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
            String name = in.next();
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                setName(name);
                temp4 = true;
            } else
                System.out.println("enter correct name");
        } while (!temp4);
    }


    protected void validatePan() {
    do {
        System.out.println("Enter PAN card number");
        Pattern pattern = Pattern.compile("[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}");
        String panNo = in.next();
        Matcher matcher = pattern.matcher(panNo);
        if (matcher.matches()) {
            setPanNo(panNo);
            temp3 = true;
        } else
            System.out.println("enter valid pan number");
    } while (!temp3);
}
   protected void validateMobileNo(){
    do {
        System.out.println("Enter valid 10 digit Mobile number ");
        Pattern pattern = Pattern.compile("\\d{10}");

        String mobileNo = in.next();
        Matcher matcher = pattern.matcher(mobileNo);

        if (matcher.matches()) {
            setMobileNo(mobileNo);
            temp1 = true;

        }
        else
            System.out.println("invalid mobile number");
    }while(!temp1);
}

   protected   void validateAdharNo(){
        do {
            System.out.println("Enter valid 12 digit adhar number ");
            Pattern pattern = Pattern.compile("\\d{12}");

            String adharNo = in.next();
            Matcher matcher = pattern.matcher(adharNo);

            if (matcher.matches()) {
                setAdharNo(adharNo);
                temp2 = true;

            }
            else
                System.out.println("invalid adhar number");
        }while(!temp2);
    }

    protected   void validateDateOfBirth()
    {
      int date,year,month;

      System.out.println("Birth Details ");
        do {
            System.out.println("enter year of birth");
            while (!in.hasNextInt()) {
                System.out.println("invalid year \n enter birth  year");
                in.next();
            }
            year = in.nextInt();
            if(year<1910 || year>=2018){
                System.out.println("invalid year");
            }
        }while(year<1910 || year>=2018);


      do {
          System.out.println("enter birth month");
          while (!in.hasNextInt())
          {
              System.out.println("invalid month enter month in number");
              in.next();
          }


          month = in.nextInt();
          if(month<=0 || month>12)
          {
              System.out.println("invalid month");
          }
      } while(month<=0 || month>12);


       do {
           System.out.println("enter birth date  ");
           while (!in.hasNextInt()) {
               System.out.println("invalid date");
               in.next();
           }
           date = in.nextInt();
           if(date<0 || date>31 || (date>30 && (month==2 || month==4 || month==6 || month==9 || month==11)) || (date>29 && month==2) || (date>28 && month==2 && year%4!=0)){
               System.out.println("invalid date");
           }
       }while (date<0 || date>31 || (date>30 && (month==2 || month==4 || month==6 || month==9 || month==11)) || (date>29 && month==2) || (date>28 && month==2 && year%4!=0));



        dateOfBirth=Integer.toString(date)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
        setDateOfBirth(dateOfBirth);
        int age=2018-year;
        System.out.println("age="+age);


        }



}