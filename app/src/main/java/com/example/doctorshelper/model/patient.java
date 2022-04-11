package com.example.doctorshelper.model;

public class patient {
    private int id;
    private String name;
    private String phoneNumber;
    private String disease;
    private String next_appointment;
    public patient(String name, String phoneNumber,String disease, String next_appointment)
    {
        this.name =name;
        this.phoneNumber =phoneNumber;
        this.disease = disease;
        this.next_appointment = next_appointment;
    }
    public patient(int id,String name, String phoneNumber,String disease, String next_appointment)
    {
        this.id = id;
        this.name =name;
        this.phoneNumber =phoneNumber;
        this.disease = disease;
        this.next_appointment = next_appointment;
    }
    public patient()
        {

        }
        public int getId()
            {
                return id;
            }
            public void setId(int id)
                {
                    this.id =id;
                }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getNext_appointment() {
        return next_appointment;
    }

    public void setNext_appointment(String next_appointment) {
        this.next_appointment = next_appointment;
    }
}
