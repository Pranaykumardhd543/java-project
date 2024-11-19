import java.util.Scanner;
import java.util.regex.PatternSyntaxException;
// import java.text.ParseException;
// import java.text.SimpledayFormat;
// import java.time.Localday;
// import java.time.format.dayTimeFormatter;
// import java.time.format.dayTimeParseException;
//import java.util.Calendar;
//import java.util.day;
class mainproj{
    public static int dat1,dat2,mon1,mon2,year1,year2;
    public static String param,day,format,dlc;
    public static  Scanner sc=new Scanner(System.in);
      public static void main(String[] args) {
           System.out.println("enter an option to find the appropriate age or DOB");
           System.out.println("1.age");
           System.out.println("2.DOB");
           Scanner sc=new Scanner(System.in);
           int a=sc.nextInt();
           switch(a){
            case 1:
            age();
            break;
            case 2:
            dob();
            break;
            default:
            System.out.println("enter a correct option");
            break;
           }
           sc.close();

        }
        static void age(){
            input i=new input();
            param=i.parametersString();
            day=i.dayString();
            format=i.getFormat();
            dlc=i.getDlc();
            String param1=param.substring(4,param.length());
            String regex="\\"+dlc;
            try{
            String inp1[]=param1.split(regex);
            String inp2[]=day.split(regex);
           String uprFormat= format.toUpperCase();
           getvar var=new getvar();
            if(uprFormat.equals("DD"+dlc+"MM"+dlc+"YYYY"))
            {
                    dat1=var.getvariable(inp1, 0);
                    mon1=var.getvariable(inp1, 1);
                    year1=var.getvariable(inp1, 2);
                    dat2=var.getvariable(inp2, 0);
                    mon2=var.getvariable(inp2, 1);
                    year2=var.getvariable(inp2, 2);
                    if(isValidday(dat1,mon1,year1)&&isValidday(dat2, mon2, year2))
                    {
                        int resdays=dat2-dat1;
                        int resmon=mon2-mon1;
                        int resyear=year2-year1;
                        if(resdays<=0&&resmon<=0){
                           System.out.println("age is:"+(resyear-1)+" years "+((12+resmon)-1)+" months "+(31+resdays)+" days ");
                        }
                        else if(resdays<=0)
                         System.out.println("age is:"+(resyear)+" years "+(resmon-1)+" months "+((31+resdays))+" days ");
                        else if(resmon<=0){
                            System.out.println("age is:"+resyear+" years "+(12-resmon)+" months "+(resdays)+" days ");
                         }
                         else
                         {
                            System.out.println("age is:"+resyear+" years "+resmon+" months "+(resdays)+" days ");
                         }
                    }
                    else{
                        System.out.println("enter a valid date");
                    }
            }
           else if(uprFormat.equals("YYYY"+dlc+"MM"+dlc+"DD"))
            {
                dat1=var.getvariable(inp1, 2);
                mon1=var.getvariable(inp1, 1);
                year1=var.getvariable(inp1, 0);
                dat2=var.getvariable(inp2, 2);
                mon2=var.getvariable(inp2, 1);
                year2=var.getvariable(inp2, 0);
                    
                    if(isValidday(dat1,mon1,year1)&&isValidday(dat2, mon2, year2))
                    {
                        int resdays=dat2-dat1;
                        int resmon=mon2-mon1;
                        int resyear=year2-year1;
                        if(resdays<=0&&resmon<=0){
                            System.out.println("age is:"+(resyear-1)+" years "+((12+resmon)-1)+" months "+(31+resdays)+" days ");
                         }
                         else if(resdays<=0)
                          System.out.println("age is:"+(resyear)+" years "+(resmon-1)+" months "+((31+resdays))+" days ");
                         else if(resmon<=0){
                             System.out.println("age is:"+resyear+" years "+(12-resmon)+" months "+(resdays)+" days ");
                          }
                          else
                          {
                             System.out.println("age is:"+resyear+" years "+resmon+" months "+(resdays)+" days ");
                          }
                    }
                    else{
                        System.out.println("enter a valid date");
                    }
                }
                else if(uprFormat.equals("MM"+dlc+"DD"+dlc+"YYYY"))
                {
                    dat1=var.getvariable(inp1,1);
                    mon1=var.getvariable(inp1, 0);
                    year1=var.getvariable(inp1, 2);
                    dat2=var.getvariable(inp2, 1);
                    mon2=var.getvariable(inp2, 0);
                    year2=var.getvariable(inp2, 2);
                        if(isValidday(dat1,mon1,year1)&&isValidday(dat2, mon2, year2))
                        {
                            int resdays=dat2-dat1;
                            int resmon=mon2-mon1;
                            int resyear=year2-year1;
                            if(resdays<=0&&resmon<=0){
                                System.out.println("age is:"+(resyear-1)+" years "+((12+resmon)-1)+" months "+(31+resdays)+" days ");
                             }
                             else if(resdays<=0)
                              System.out.println("age is:"+(resyear)+" years "+(resmon-1)+" months "+((31+resdays))+" days ");
                             else if(resmon<=0){
                                 System.out.println("age is:"+resyear+" years "+(12-resmon)+" months "+(resdays)+" days ");
                              }
                              else
                              {
                                 System.out.println("age is:"+resyear+" years "+resmon+" months "+(resdays)+" days ");
                              }
                        }
                        else{
                            System.out.println("enter a valid day");
                        }
                    }
                    else{
                    System.out.println("enter a correct date format with correct delimeter character");
                    }
            }
            catch(PatternSyntaxException e){
                System.out.println("the exception occured during split:"+e.getMessage());
            }
        }   
        static int MAX_VALID_YR = 9999; 
        static int MIN_VALID_YR = 1800; 
        static boolean isLeap(int year) 
        { 
            
            return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)); 
        } 
        static boolean isValidday(int d,int m,int y) 
        { 
           
            if (y>MAX_VALID_YR||y<MIN_VALID_YR) 
                return false; 
            if (m<1||m>12) 
                return false; 
            if (d<1||d>31) 
                return false; 
            if (m==2)  
            { 
                if (isLeap(y)) 
                    return (d <= 29); 
                else
                    return (d <= 28); 
            } 
            if (m==4||m==6||m==9||m==11) 
                return (d<=30); 
      
            return true; 
        }
        static void dob(){
            input i=new input();
            String param=i.parametersString();
            String day=i.dayString();
            String format=i.getFormat();
            String dlc=i.getDlc();
            String param1=param.substring(4,param.length());
            String regex="\\"+dlc;
            String upFormat= format.toUpperCase();
            try {
            String inp1[]=param1.split(regex);
            String inp2[]=day.split(regex);
            getvar var=new getvar();
             if(upFormat.equals("DD"+dlc+"MM"+dlc+"YYYY"))
                {   
                    dat1=var.getvariable(inp1, 0);
                    mon1=var.getvariable(inp1, 1);
                    year1=var.getvariable(inp1, 2);
                    dat2=var.getvariable(inp2, 0);
                    mon2=var.getvariable(inp2, 1);
                    year2=var.getvariable(inp2, 2);
                    
                    if(isValidday(dat2, mon2, year2))
                    {
                        int resdays=dat2-dat1;
                        int resmon=mon2-mon1;
                        int resyear=year2-year1;
                        if(resmon<=0){
                            resyear-=1;
                            resmon+=12;
                        }
                        if(resdays<=0){
                            resmon-=1;
                            resdays+=31;
                            if(resmon<=0){
                                resmon=12;
                                resyear-=1;
                            }
                        }
                        System.out.println("the dob is:"+resdays+dlc+resmon+dlc+resyear);
                    }
                    else{
                        System.out.println("enter a correct date");
                    }
                }
                else if(upFormat.equals("YYYY"+dlc+"MM"+dlc+"DD"))
                {   
                    dat1=var.getvariable(inp1, 2);
                    mon1=var.getvariable(inp1, 1);
                    year1=var.getvariable(inp1, 0);
                    dat2=var.getvariable(inp2, 2);
                    mon2=var.getvariable(inp2, 1);
                    year2=var.getvariable(inp2, 0);
                    
                    if(isValidday(dat2, mon2, year2))
                    {
                        int resdays=dat2-dat1;
                        int resmon=mon2-mon1;
                        int resyear=year2-year1;
                        if(resmon<=0){
                            resyear-=1;
                            resmon+=12;
                        }
                        if(resdays<=0){
                            resmon-=1;
                            resdays+=31;
                            if(resmon<=0){
                                resmon=12;
                                resyear-=1;
                            }
                        }
                        System.out.println("the dob is:"+resdays+dlc+resmon+dlc+resyear);
                    }
                    else{
                        System.out.println("enter a correct date");
                    }
                }
               else if(upFormat.equals("MM"+dlc+"DD"+dlc+"YYYY"))
                {   
                    dat1=var.getvariable(inp1, 1);
                    mon1=var.getvariable(inp1, 0);
                    year1=var.getvariable(inp1,2);
                    dat2=var.getvariable(inp2, 1);
                    mon2=var.getvariable(inp2, 0);
                    year2=var.getvariable(inp2, 2);
                    
                    if(isValidday(dat2, mon2, year2))
                    {
                        int resdays=dat2-dat1;
                        int resmon=mon2-mon1;
                        int resyear=year2-year1;
                        if(resmon<=0){
                            resyear-=1;
                            resmon+=12;
                        }
                        if(resdays<=0){
                            resmon-=1;
                            resdays+=31;
                            if(resmon<=0){
                                resmon=12;
                                resyear-=1;
                            }
                        }
                        System.out.println("the dob is:"+resdays+dlc+resmon+dlc+resyear);
                    }
                    else{
                        System.out.println("enter a correct date");
                    }
                }
                else{
                System.out.println("enter a correct date format with correct delimeter character");
                }
            } catch (PatternSyntaxException e) {
                System.out.println("the exception occured during split:"+e.getMessage());
            }
        }
        public static class input {
            public Scanner sc=new Scanner(System.in);
          public String  parametersString(){
                System.out.println("enter a parameter");
                String paraString=sc.nextLine();
                return paraString;
            }
            public String dayString(){
            System.out.println("enter current day or reference day");
                String dat=sc.nextLine();
                return  dat;
            }
            public String  getFormat(){
            System.out.println("enter day format");
                String format=sc.nextLine();
                return format;
            }
            public String  getDlc(){
             System.out.println("enter a delimeter character");
                String dlc=sc.nextLine();
                return dlc;
            }
        }
    }
        public class getvar {
        public int getvariable(String inp[],int index){
            return Integer.parseInt(inp[index]);
        }   
        }
        
