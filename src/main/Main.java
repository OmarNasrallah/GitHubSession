package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import students.Students;

public class Main {

	public static void main(String test[]) {

		try {
			Students students[];
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("How many user you want to input ?");
			int lenghtArray = Integer.parseInt(reader.readLine());
			students = new Students[lenghtArray];
			Integer counter = 0;
			while (counter < lenghtArray) {

				System.out.println("Do you want Create Student(y/n)?");
				String validation = reader.readLine();
				if (validation.equalsIgnoreCase("y")) {
					System.out.println("input id :");
					Integer id = Integer.parseInt(reader.readLine());
					System.out.println("input name :");
					String name = reader.readLine();
					System.out.println("input mark:");
					Integer mark = Integer.parseInt(reader.readLine());
					System.out.println("input age :");
					Integer age = Integer.parseInt(reader.readLine());
					System.out.println("input wasta (true/false)");
					Boolean wasta = Boolean.parseBoolean(reader.readLine());

					Students student = new Students(id, name, wasta);
					student.setMark(mark);
					student.setAge(age);
					if (student.getAge() == null) {
						System.out.println("Invalid Age ,Please input the correct data");
						continue;
					}
					if (student.getMark() == null) {
						System.out.println("Invalid Mark ,Please input the correct data");
						continue;
					}

					students[counter] = student;
					System.out.println("The user created sucss");

				} else if (validation.equalsIgnoreCase("n")) {
					finalResult(students, counter);
					break;
				} else {
					System.out.println("Invalid input ");
					continue;
				}

				counter++;
			}
			finalResult(students, counter);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void finalResult(Students[] students, Integer counter) {

		int counterA = 0;
		int counterB = 0;
		int counterC = 0;
		int counterF = 0;
		int maxMark = 0;

		int minMark = 100;

		Students maxMarkObj = null;
		Students minMarkObj = null;
		for (int i = 0; i < counter; i++) {
			Students var = students[i];
			if (var != null) {
				var.convertToDegree();
				var.checkIfWasta();

				switch (students[i].getDegree()) {
				case 'A':
					counterA++;
					break;
				case 'B':
					counterB++;
					break;
				case 'C':
					counterC++;
					break;
				case 'F':
					counterF++;

				}
				if (var.getMark() > maxMark) {
					maxMark = var.getMark();
					maxMarkObj = var;
				}
				if (var.getMark() < minMark) {
					minMark = var.getMark();
					minMarkObj = var;
				}
			}

		}

		System.out.println(" you have " + counter + " User :");
		System.out.println(counterA + " have A Degree");
		System.out.println(counterB + " have B Degree");
		System.out.println(counterC + " have C Degree");
		System.out.println(counterF + " have F	 Degree");
		if (maxMarkObj != null)
			System.out.println("The highest mark=" + maxMarkObj.getMark() + " for " + maxMarkObj.getName() + " with id="
					+ maxMarkObj.getId());
		if (minMarkObj != null)
			System.out.println("The lowest mark=" + minMarkObj.getMark() + " for " + minMarkObj.getName() + " with id="
					+ minMarkObj.getId());
	}

}
