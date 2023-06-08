package com.example.post.model;

import java.util.List;

public class Post {
    private int _id;
    private int ownerId;
    private String caption;
    private String attachmentId1;
    private String attachmentId2;
    private long createdDate;
    private long lastModifyDate;
    private boolean isDeleted;
    private int Countlike;
    private int __v;
    private int CountComment;
    private UserInfo userInfo;

    public class UserInfo {
        private int age;
        private int height;
        private int weight;
        private int workingLevel;
        private String avtId;
        private String coverId;
        private int wallet;
        private boolean isBan;
        private int status;
        private int lastActive;
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

        // Các phương thức getter và setter
        // ...

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

        public int getLastActive() {
            return lastActive;
        }

        public String getBankAccount() {
            return bankAccount;
        }

        public String getBankName() {
            return bankName;
        }

        public int getId() {
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

        public int get__v() {
            return __v;
        }
    }

    // Các phương thức getter và setter
    // ...
    public int getCountlike() {
        return Countlike;
    }

    public void setCountlike(int countlike) {
        Countlike = countlike;
    }

    public int getId() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setAttachmentId1(String attachmentId1) {
        this.attachmentId1 = attachmentId1;
    }

    public void setAttachmentId2(String attachmentId2) {
        this.attachmentId2 = attachmentId2;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifyDate(long lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public void setCountComment(int countComment) {
        CountComment = countComment;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getCaption() {
        return caption;
    }

    public String getAttachmentId1() {
        return attachmentId1;
    }

    public String getAttachmentId2() {
        return attachmentId2;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public long getLastModifyDate() {
        return lastModifyDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public int get__v() {
        return __v;
    }

    public int getCountComment() {
        return CountComment;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}


