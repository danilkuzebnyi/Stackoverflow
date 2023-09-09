package org.danylo.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.stream.Collectors;

public class StackoverflowUser {
    @SerializedName("user_id")
    private String id;

    @SerializedName("display_name")
    private String username;

    private String location;

    @SerializedName("answer_count")
    private String answerCount;

    @SerializedName("question_count")
    private String questionCount;

    private List<StackoverflowTag> tags;

    @SerializedName("link")
    private String linkToProfile;

    @SerializedName("profile_image")
    private String linkToAvatar;

    private String reputation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(String answerCount) {
        this.answerCount = answerCount;
    }

    public String getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(String questionCount) {
        this.questionCount = questionCount;
    }

    public List<StackoverflowTag> getTags() {
        return tags;
    }

    public void setTags(List<StackoverflowTag> tags) {
        this.tags = tags;
    }

    public String getLinkToProfile() {
        return linkToProfile;
    }

    public void setLinkToProfile(String linkToProfile) {
        this.linkToProfile = linkToProfile;
    }

    public String getLinkToAvatar() {
        return linkToAvatar;
    }

    public void setLinkToAvatar(String linkToAvatar) {
        this.linkToAvatar = linkToAvatar;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return "StackoverflowUser{" + "\n" +
                "username='" + username + '\'' + ",\n" +
                "location='" + location + '\'' + ",\n" +
                "answerCount='" + answerCount + '\'' + ",\n" +
                "questionCount='" + questionCount + '\'' + ",\n" +
                "tags='" + (tags != null ? tags.stream().map(StackoverflowTag::getName)
                        .collect(Collectors.joining(", ")) : "") + '\'' + ",\n" +
                "linkToProfile='" + linkToProfile + '\'' + ",\n" +
                "linkToAvatar='" + linkToAvatar + '\'' + '}';
    }
}
