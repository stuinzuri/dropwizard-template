package ch.geekomatic.dwtemplate;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class AppConfiguration extends Configuration {
    @NotEmpty
    private String templateStringValue;
    private int    templateIntValue;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate() {
        return templateStringValue;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.templateStringValue = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
	public int getTemplateIntValue() {
		return templateIntValue;
	}

    @JsonProperty
	public void setTemplateIntValue(int templateIntValue) {
		this.templateIntValue = templateIntValue;
	}
}

