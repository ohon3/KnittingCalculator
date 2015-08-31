package stitchmath;

public class StitchMath {
	private int stitches;
	private int partition;

	public StitchMath() {
		stitches = 0;
		partition = 8;
	}

	public void setStitches(int input) {
		stitches = input;
	}

	public int getStitches() {
		return stitches;
	}

	public void setPartition(int parts) {
		partition = parts;
	}

	public int getParitition() {
		return partition;
	}

	public boolean isEven() {
		//find of if stitches are even or odd
		return (stitches % partition == 0) ? true : false;
	}

	public void reset() {
		partition = 8;
		stitches = 0;
	}

	public String evenNumberInstructions() { 
		int decrease = (stitches / partition) - 2;
		String instruction;

		if (decrease == 0) {
			instruction = "Knit the next two stitches together.";
		} else {
			String plural = (decrease == 1 ? "stitch" : "stitches");
			instruction = "For this round, knit " + decrease + " " + plural + " normally before knitting the next two stitches together.";
		}

		stitches -= partition;

		return instruction;
	}

	public String oddNumberInstructions() {
		int remainder = stitches % partition;

		//note: suggest they knit 3 together to even it out
		String plural = (remainder == 1 ? "stitch" : "stitches");

		stitches -= remainder;

		int decrease = (stitches / partition);

		//there is a case when the remainder is the same as the regular partition
		if (remainder == decrease) {
			//System.out.println("Extra stitches: " + remainder);
			//System.out.println("Regular section: " + decrease);
			//System.out.println("Redirecting to even number of stitches");
			partition++;
			stitches += remainder;
			return evenNumberInstructions();
		}

		String instruction = "Knit " + (decrease-2) + " stitches normally before knitting the next two stitches together."
				+ " Repeat until you have " + remainder + " " + plural +" left. Knit these normally to finish the"
				+ " round.";

		stitches += remainder - partition;

		return instruction;
	}

	public void printInstructions() {
		while (stitches > 10) {
			boolean flag = isEven();

			String instruction;
			if (flag) {
				instruction = evenNumberInstructions();
			} else {
				instruction = oddNumberInstructions();
			}
			System.out.print(instruction);
			System.out.print(" Repeat until you reach the end of the round.\n");
			System.out.println("You should have "+ stitches + " stitches left on your needles.");
			if (stitches > 10) {
				System.out.println("Knit the next round normally.");
			}
		}
		System.out.println("At this point you will want to cut a long tail and weave it through "
				+ "the remaining stitches to close up your hat. You're done!");
		System.out.println("Congratulations on finishing your hat!");
	}

}
