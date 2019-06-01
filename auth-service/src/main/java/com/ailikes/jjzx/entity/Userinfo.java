package com.ailikes.jjzx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author ailikes
 * @since 2019-06-01
 */
@TableName("t_userinfo")
public class Userinfo extends Model<Userinfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * ???
     */
    @TableField("USERNAME")
    private String username;
    /**
     * ??
     */
    @TableField("PASSWORD")
    private String password;
    @TableField("EXPERIENCE")
    private Integer experience;
    @TableField("RANKID")
    private Integer rankid;
    @TableField("IMAGE")
    private String image;
    @TableField("PROVINCE")
    private String province;
    /**
     * ??
     */
    @TableField("EMAIL")
    private String email;
    @TableField("SORT")
    private Integer sort;
    @TableField("ISPRIOR")
    private String isprior;
    /**
     * ????
     */
    @TableField("TYPE")
    private String type;
    /**
     * ??ID
     */
    @TableField("ROLEID")
    private Integer roleid;
    /**
     * ??
     */
    @TableField("STATUS")
    private String status;
    @TableField("REGISTERDATE")
    private String registerdate;
    @TableField("LOGINDATE")
    private String logindate;
    @TableField("ISHIDDEN")
    private String ishidden;
    @TableField("CITY")
    private String city;
    @TableField("AREA")
    private String area;
    @TableField("AUDITIONTIMES")
    private Integer auditiontimes;
    @TableField("ISHISTORY")
    private String ishistory;
    private Integer agentuserinfoid;
    private String agenttype;
    private String agentcanceldatetime;
    private Integer comment;
    private Double commentscore;
    private String gender;
    private String qafirstdatetime;
    private Double qaanswerscore;
    private Double qavotescore;
    private Double lastmonthmoney;
    /**
     * ???????
     */
    private String isorg;
    private Integer errorlogin;
    private String isfriend;
    private Integer online;
    private String orignalimage;
    @TableField("agentuserinfoPid")
    private Integer agentuserinfoPid;
    private String txpassword;
    private String zxdate;
    private Integer initagentuserinfoid;
    private Double weight;
    private String isfull;
    private String agentuserinfoname;
    private String agentuserinfopidname;
    private String updateusername1;
    private String updateusername2;
    private String updategwusername1;
    private String updategwusername2;
    private Integer teachingconsultantid;
    private String teachingconsultantname;
    private Integer agentgwid;
    private String agentgwname;
    private Integer agentgwglid;
    private String agentgwglname;
    private Long logindatemillion;
    private String sfhmhd;
    private String dlbz;
    /**
     * ???  0-999
     */
    private String bjs;
    /**
     * ??????
     */
    @TableField("agentBj")
    private String agentBj;
    /**
     * ???????  0:? 1:?
     */
    private String isbtf;
    /**
     * ???? 0??? ?1???? ?2vip??
     */
    private String ismember;
    /**
     * ???
     */
    private String iscode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getRankid() {
        return rankid;
    }

    public void setRankid(Integer rankid) {
        this.rankid = rankid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsprior() {
        return isprior;
    }

    public void setIsprior(String isprior) {
        this.isprior = isprior;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    public String getIshidden() {
        return ishidden;
    }

    public void setIshidden(String ishidden) {
        this.ishidden = ishidden;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAuditiontimes() {
        return auditiontimes;
    }

    public void setAuditiontimes(Integer auditiontimes) {
        this.auditiontimes = auditiontimes;
    }

    public String getIshistory() {
        return ishistory;
    }

    public void setIshistory(String ishistory) {
        this.ishistory = ishistory;
    }

    public Integer getAgentuserinfoid() {
        return agentuserinfoid;
    }

    public void setAgentuserinfoid(Integer agentuserinfoid) {
        this.agentuserinfoid = agentuserinfoid;
    }

    public String getAgenttype() {
        return agenttype;
    }

    public void setAgenttype(String agenttype) {
        this.agenttype = agenttype;
    }

    public String getAgentcanceldatetime() {
        return agentcanceldatetime;
    }

    public void setAgentcanceldatetime(String agentcanceldatetime) {
        this.agentcanceldatetime = agentcanceldatetime;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Double getCommentscore() {
        return commentscore;
    }

    public void setCommentscore(Double commentscore) {
        this.commentscore = commentscore;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQafirstdatetime() {
        return qafirstdatetime;
    }

    public void setQafirstdatetime(String qafirstdatetime) {
        this.qafirstdatetime = qafirstdatetime;
    }

    public Double getQaanswerscore() {
        return qaanswerscore;
    }

    public void setQaanswerscore(Double qaanswerscore) {
        this.qaanswerscore = qaanswerscore;
    }

    public Double getQavotescore() {
        return qavotescore;
    }

    public void setQavotescore(Double qavotescore) {
        this.qavotescore = qavotescore;
    }

    public Double getLastmonthmoney() {
        return lastmonthmoney;
    }

    public void setLastmonthmoney(Double lastmonthmoney) {
        this.lastmonthmoney = lastmonthmoney;
    }

    public String getIsorg() {
        return isorg;
    }

    public void setIsorg(String isorg) {
        this.isorg = isorg;
    }

    public Integer getErrorlogin() {
        return errorlogin;
    }

    public void setErrorlogin(Integer errorlogin) {
        this.errorlogin = errorlogin;
    }

    public String getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getOrignalimage() {
        return orignalimage;
    }

    public void setOrignalimage(String orignalimage) {
        this.orignalimage = orignalimage;
    }

    public Integer getAgentuserinfoPid() {
        return agentuserinfoPid;
    }

    public void setAgentuserinfoPid(Integer agentuserinfoPid) {
        this.agentuserinfoPid = agentuserinfoPid;
    }

    public String getTxpassword() {
        return txpassword;
    }

    public void setTxpassword(String txpassword) {
        this.txpassword = txpassword;
    }

    public String getZxdate() {
        return zxdate;
    }

    public void setZxdate(String zxdate) {
        this.zxdate = zxdate;
    }

    public Integer getInitagentuserinfoid() {
        return initagentuserinfoid;
    }

    public void setInitagentuserinfoid(Integer initagentuserinfoid) {
        this.initagentuserinfoid = initagentuserinfoid;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getIsfull() {
        return isfull;
    }

    public void setIsfull(String isfull) {
        this.isfull = isfull;
    }

    public String getAgentuserinfoname() {
        return agentuserinfoname;
    }

    public void setAgentuserinfoname(String agentuserinfoname) {
        this.agentuserinfoname = agentuserinfoname;
    }

    public String getAgentuserinfopidname() {
        return agentuserinfopidname;
    }

    public void setAgentuserinfopidname(String agentuserinfopidname) {
        this.agentuserinfopidname = agentuserinfopidname;
    }

    public String getUpdateusername1() {
        return updateusername1;
    }

    public void setUpdateusername1(String updateusername1) {
        this.updateusername1 = updateusername1;
    }

    public String getUpdateusername2() {
        return updateusername2;
    }

    public void setUpdateusername2(String updateusername2) {
        this.updateusername2 = updateusername2;
    }

    public String getUpdategwusername1() {
        return updategwusername1;
    }

    public void setUpdategwusername1(String updategwusername1) {
        this.updategwusername1 = updategwusername1;
    }

    public String getUpdategwusername2() {
        return updategwusername2;
    }

    public void setUpdategwusername2(String updategwusername2) {
        this.updategwusername2 = updategwusername2;
    }

    public Integer getTeachingconsultantid() {
        return teachingconsultantid;
    }

    public void setTeachingconsultantid(Integer teachingconsultantid) {
        this.teachingconsultantid = teachingconsultantid;
    }

    public String getTeachingconsultantname() {
        return teachingconsultantname;
    }

    public void setTeachingconsultantname(String teachingconsultantname) {
        this.teachingconsultantname = teachingconsultantname;
    }

    public Integer getAgentgwid() {
        return agentgwid;
    }

    public void setAgentgwid(Integer agentgwid) {
        this.agentgwid = agentgwid;
    }

    public String getAgentgwname() {
        return agentgwname;
    }

    public void setAgentgwname(String agentgwname) {
        this.agentgwname = agentgwname;
    }

    public Integer getAgentgwglid() {
        return agentgwglid;
    }

    public void setAgentgwglid(Integer agentgwglid) {
        this.agentgwglid = agentgwglid;
    }

    public String getAgentgwglname() {
        return agentgwglname;
    }

    public void setAgentgwglname(String agentgwglname) {
        this.agentgwglname = agentgwglname;
    }

    public Long getLogindatemillion() {
        return logindatemillion;
    }

    public void setLogindatemillion(Long logindatemillion) {
        this.logindatemillion = logindatemillion;
    }

    public String getSfhmhd() {
        return sfhmhd;
    }

    public void setSfhmhd(String sfhmhd) {
        this.sfhmhd = sfhmhd;
    }

    public String getDlbz() {
        return dlbz;
    }

    public void setDlbz(String dlbz) {
        this.dlbz = dlbz;
    }

    public String getBjs() {
        return bjs;
    }

    public void setBjs(String bjs) {
        this.bjs = bjs;
    }

    public String getAgentBj() {
        return agentBj;
    }

    public void setAgentBj(String agentBj) {
        this.agentBj = agentBj;
    }

    public String getIsbtf() {
        return isbtf;
    }

    public void setIsbtf(String isbtf) {
        this.isbtf = isbtf;
    }

    public String getIsmember() {
        return ismember;
    }

    public void setIsmember(String ismember) {
        this.ismember = ismember;
    }

    public String getIscode() {
        return iscode;
    }

    public void setIscode(String iscode) {
        this.iscode = iscode;
    }
}
