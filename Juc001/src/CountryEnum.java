import jdk.nashorn.internal.objects.annotations.Getter;

public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"韩"),SIX(6,"魏");


            private  Integer retCoDE;
            private  String retMessage;

    public Integer getRetCoDE() {
        return retCoDE;
    }

    public void setRetCoDE(Integer retCoDE) {
        this.retCoDE = retCoDE;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    //枚举是特殊的类，要写构造器
    CountryEnum(Integer retCoDE, String retMessage) {
        this.retCoDE = retCoDE;
        this.retMessage = retMessage;
    }


    public  static  CountryEnum forEach_countryEnum(int index){

        CountryEnum[]  myarray =CountryEnum.values();
        for (CountryEnum countryEnum : myarray) {
                if(index == countryEnum.getRetCoDE()){
                    return countryEnum;
                }
        }

        return null;
    }







}
