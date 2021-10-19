package org.mls.surveyconduct.dto;

import javax.validation.constraints.NotBlank;

public class AddOptionDTO {

	@NotBlank(message = "Option must not be blank")
	private String label;

	public AddOptionDTO() {

	}

	public AddOptionDTO(String label) {
		this.label = label;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddOptionDTO other = (AddOptionDTO) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

}
