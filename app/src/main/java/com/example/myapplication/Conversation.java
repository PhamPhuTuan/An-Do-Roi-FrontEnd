package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Conversation {
    private int _id;
    private int userId;
    private int partnerId;
    private boolean isGroupConver;
    private boolean isBlock;
    private long lastActive;
    private String nickname;
    private String Message;
    private int __v;
    private PartnerInfo partnerinfo;


    public void setMessage(String message) {
        Message = message;
    }
    public String getMessage() {
        return Message;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public boolean isGroupConver() {
        return isGroupConver;
    }

    public void setGroupConver(boolean groupConver) {
        isGroupConver = groupConver;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }

    public long getLastActive() {
        return lastActive;
    }

    public void setLastActive(long lastActive) {
        this.lastActive = lastActive;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public PartnerInfo getPartnerinfo() {
        return partnerinfo;
    }

    public void setPartnerinfo(PartnerInfo partnerinfo) {
        this.partnerinfo = partnerinfo;
    }

    public class PartnerInfo {
        private int age;
        private int height;
        private int weight;
        private int workingLevel;
        private String avtId;
        private String coverId;
        private int wallet;
        private boolean isBan;
        private int status;
        private long lastActive;
        private String bankAccount;
        private String bankName;
        private int _id;
        private String firstname;
        private String lastname;
        private String gender;
        private String email;
        private String phonenumber;
        private String address;
        private int __v;

        // Các phương thức getter và setter cho các thuộc tính

        public void setAge(int age) {
            this.age = age;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setWorkingLevel(int workingLevel) {
            this.workingLevel = workingLevel;
        }

        public void setAvtId(String avtId) {
            this.avtId = avtId;
        }

        public void setCoverId(String coverId) {
            this.coverId = coverId;
        }

        public void setWallet(int wallet) {
            this.wallet = wallet;
        }

        public void setBan(boolean ban) {
            isBan = ban;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setLastActive(long lastActive) {
            this.lastActive = lastActive;
        }

        public void setBankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        public int getWorkingLevel() {
            return workingLevel;
        }

        public String getAvtId() {
            return avtId;
        }

        public String getCoverId() {
            return coverId;
        }

        public int getWallet() {
            return wallet;
        }

        public boolean isBan() {
            return isBan;
        }

        public int getStatus() {
            return status;
        }

        public long getLastActive() {
            return lastActive;
        }

        public String getBankAccount() {
            return bankAccount;
        }

        public String getBankName() {
            return bankName;
        }

        public int get_id() {
            return _id;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getGender() {
            return gender;
        }

        public String getEmail() {
            return email;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public String getAddress() {
            return address;
        }

        // ...
    }
}
