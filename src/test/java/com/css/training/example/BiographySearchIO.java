package com.css.training.example;

public class BiographySearchIO {
	public String qText;
	public String wikiLink;
	public String born;
	public String linkStarts;
	public String linkEnds;

	@Override
	public String toString() {
		if (wikiLink == null) {
			return qText + "," + linkStarts + " " + linkEnds + "," + born;
		} else {
			return qText + "," + wikiLink + "," + born;
		}
	}
}
