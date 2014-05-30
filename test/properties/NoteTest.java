package properties;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoteTest {

	private NotePitchLookup notesAndPitch = new NotePitchLookup();

	@Test
	public void returnsPitchGivenNote() {
		Note note = notesAndPitch.lookup("C");
		assertEquals("C", note.name);
		assertEquals(Integer.valueOf(4), note.pitch);
	}
	
	@Test
	public void returnsSharpNote() {
		Note note = notesAndPitch.lookupSharp("C");
		assertEquals("C#", note.name);
		assertEquals(Integer.valueOf(5), note.pitch);
	}

	@Test
	public void returnsFlatNote() {
		Note note = notesAndPitch.lookupFlat("D");
		assertEquals("Db", note.name);
		assertEquals(Integer.valueOf(5), note.pitch);
	}
	
	@Test
	public void returnsBforFlatC() {
		Note note = notesAndPitch.lookupFlat("C");
		assertEquals("B", note.name);
		assertEquals(Integer.valueOf(3), note.pitch);
	}
	
	@Test
	public void returnsCforSharpB() {
		Note note = notesAndPitch.lookupSharp("B");
		assertEquals("C", note.name);
		assertEquals(Integer.valueOf(16), note.pitch);
	}
	
	@Test
	public void returnsFrequencyForC() {
		Double freq = notesAndPitch.lookupFrequency("C");
		assertEquals(Double.valueOf(NotePitchLookup.FREQ + 4), freq);
	}
	
	@Test
	public void returnsFrequencyForG() {
		Double freq = notesAndPitch.lookupFrequency("G");
		assertEquals(Double.valueOf(NotePitchLookup.FREQ + 11), freq);
	}
	
	@Test
	public void differenceBetweenTwoNotes() throws Exception {
		Interval interval = notesAndPitch.getInterval("C", "E");
		assertEquals(Interval.MAJOR_THIRD, interval);
	}

}
