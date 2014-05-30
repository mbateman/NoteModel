package properties;

import java.util.HashMap;
import java.util.Map;

public class NotePitchLookup {
	public static final int FREQ = 440;
	public Map<String, Note> notesAndPitch;

	public NotePitchLookup() {
		notesAndPitch = new HashMap<String, Note>();
		notesAndPitch.put("A", new Note("A", 1));
		notesAndPitch.put("B", new Note("B", 3));
		notesAndPitch.put("C", new Note("C", 4));
		notesAndPitch.put("D", new Note("D", 6));
		notesAndPitch.put("E", new Note("E", 8));
		notesAndPitch.put("F", new Note("F", 9));
		notesAndPitch.put("G", new Note("G", 11));
	}

	public Note lookup(String note) {
		return notesAndPitch.get(note);
	}

	public Note lookupSharp(String note) {
		Note sharp = notesAndPitch.get(note);
		if (note.equals("B")) {
			Note c = notesAndPitch.get("C");
			return new Note("C", c.pitch + 12);
		}
		return new Note(sharp.name+"#", sharp.pitch + 1);
	}

	public Note lookupFlat(String note) {
		Note flat = notesAndPitch.get(note);
		if (note.equals("C")) {
			return new Note("B", flat.pitch - 1);
		}
		
		return new Note(flat.name+"b", flat.pitch - 1);
	}

	public Double lookupFrequency(String n) {
		Note note = notesAndPitch.get(n);
		return Double.valueOf(note.pitch + FREQ);
	}

	public Interval getInterval(String low, String high) {
		Note h = notesAndPitch.get(high);
		Note l = notesAndPitch.get(low);
		
		return Interval.values()[h.pitch - l.pitch];		
	}
	
}