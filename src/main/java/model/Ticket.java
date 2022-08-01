package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Объект тикета (POJO)
 */
public class Ticket {

    @SerializedName("id")
    private Integer id;

    @SerializedName("due_date")
    private String due_date;

    @SerializedName("assigned_to")
    private String assigned_to;

    @SerializedName("title")
    private String title;

    @SerializedName("created")
    private String created;

    @SerializedName("modified")
    private String modified;

    @SerializedName("submitter_email")
    private String submitter_email;

    @SerializedName("status")
    private Integer status;

    @SerializedName("on_hold")
    private Boolean on_hold;

    @SerializedName("description")
    private String description;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("last_escalation")
    private String last_escalation;

    @SerializedName("secret_key")
    private String secret_key;

    @SerializedName("queue")
    private Integer queue;

    @JsonIgnore
    @SerializedName("kbitem")
    private Integer kbitem;

    @JsonIgnore
    @SerializedName("merged_to")
    private Integer merged_to;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getOn_hold() {
        return on_hold;
    }

    public void setOn_hold(Boolean on_hold) {
        this.on_hold = on_hold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getLast_escalation() {
        return last_escalation;
    }

    public void setLast_escalation(String last_escalation) {
        this.last_escalation = last_escalation;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public Integer getKbitem() {
        return kbitem;
    }

    public void setKbitem(Integer kbitem) {
        this.kbitem = kbitem;
    }

    public Integer getMerged_to() {
        return merged_to;
    }

    public void setMerged_to(Integer merged_to) {
        this.merged_to = merged_to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(title, ticket.title)
                && Objects.equals(status, ticket.status)
                && Objects.equals(priority, ticket.priority)
                && Objects.equals(queue, ticket.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, status, priority, queue);
    }
}