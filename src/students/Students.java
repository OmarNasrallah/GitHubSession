package students;

public class Students {
	private Integer id;
	private String name;
	private Integer age;
	private Character degree;
	private Integer mark;
	private Boolean wasta;

	public Students(Integer id, String name, Boolean wasta) {
		super();
		this.id = id;
		this.name = name;
		this.wasta = wasta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		//
		if (!(age < 0 || age > 100)) {
			this.age = age;
		}

	}

	public Character getDegree() {
		return degree;
	}

	private void setDegree(Character degree) {

		switch (degree) {
		case 'A':
		case 'B':
		case 'C':
		case 'F':
			this.degree = degree;

		}
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		if (!(mark < 0 || mark > 100)) {
			this.mark = mark;

		}
	}

	public Boolean getWasta() {
		return wasta;
	}

	public void setWasta(Boolean wasta) {
		this.wasta = wasta;
	}

	public void convertToDegree() {
		if (!(mark == null || this.mark < 0 || this.mark > 100)) {
			if (mark >= 90) {
				setDegree('A');
			} else if (mark >= 70 && mark < 90) {
				setDegree('B');
			} else if (mark >= 50 && mark < 70) {
				setDegree('C');
			} else {
				setDegree('F');

			}

		}

	}

	public void checkIfWasta() {
		if (this.degree != null && wasta != null && wasta) {

			if (degree == 'B') {
				degree = 'A';
			} else if (degree == 'C') {
				degree = 'B';
			} else if (degree == 'F')
				degree = 'C';

		}

	}

}
