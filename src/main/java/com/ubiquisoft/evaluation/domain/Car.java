package com.ubiquisoft.evaluation.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

	private String year;
	private String make;
	private String model;

	private List<Part> parts;

	public Map<PartType, Integer> getMissingPartsMap() {
		HashMap<PartType, Integer> 	missingParts;

		missingParts		= new HashMap<>();

		for (PartType pt : PartType.values()) {
			if (pt == PartType.TIRE) {
				missingParts.put(pt, 4);
			} else {
				missingParts.put(pt, 1);
			}

		}
		if (parts != null) {
			for (Part part : parts) {
				PartType pt;

				pt = part.getType();

				if (missingParts.get(pt) != null) {
					missingParts.put(pt, missingParts.get(pt) - 1);
					if (missingParts.get(pt) < 1) { missingParts.remove(pt); }
				}
			}
		}
		if (missingParts.isEmpty()) { return null; }
		else { return missingParts; }
	}

	@Override
	public String toString() {
		return "Car{" +
				       "year='" + year + '\'' +
				       ", make='" + make + '\'' +
				       ", model='" + model + '\'' +
				       ", parts=" + parts +
				       '}';
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters *///region
	/* --------------------------------------------------------------------------------------------------------------- */

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters End *///endregion
	/* --------------------------------------------------------------------------------------------------------------- */

}
