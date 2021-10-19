package org.mls.surveyconduct.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OptionDTO implements Comparable<Long> {

	@NotNull(message = "Option Id must not be null")
	@Min(value = 1, message = "Option Id must be greater than zero")
	private Long id;

	@NotBlank(message = "Option must not be blank")
	private String label;

	public OptionDTO() {

	}

	public OptionDTO(String label) {
		this.label = label;
	}

	public OptionDTO(Long id, String label) {
		this.id = id;
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		OptionDTO other = (OptionDTO) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public int compareTo(Long id) {
		return this.id.compareTo(id);
	}

}
