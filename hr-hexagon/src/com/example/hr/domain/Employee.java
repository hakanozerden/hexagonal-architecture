package com.example.hr.domain;

/**
 * @author hakan.ozerden
 */
public class Employee {

	private Identity identity;
	private FullName fullname;
	private Money salary;
	private Iban iban;
	private BirthYear birthYear;
	private Department department;
	private JobType jobType;
	private Photo photo;

	public Employee(Identity identity, FullName fullname, Money salary, BirthYear birthYear) {
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.birthYear = birthYear;
	}

	public Employee(Identity identity, FullName fullname, Money salary, Iban iban, BirthYear birthYear,
			Department department, JobType jobType, Photo photo) {
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.iban = iban;
		this.birthYear = birthYear;
		this.department = department;
		this.jobType = jobType;
		this.photo = photo;
	}

	public Employee(Builder builder) {
		this.identity = builder.identity;
		this.fullname = builder.fullname;
		this.salary = builder.salary;
		this.iban = builder.iban;
		this.birthYear = builder.birthYear;
		this.department = builder.department;
		this.jobType = builder.jobType;
		this.photo = builder.photo;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public Identity getidentity() {
		return identity;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	public Money getSalary() {
		return salary;
	}

	public void setSalary(Money salary) {
		this.salary = salary;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
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
		Employee other = (Employee) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullname=" + fullname + ", salary=" + salary + ", iban=" + iban
				+ ", birthYear=" + birthYear + ", department=" + department + ", jobType=" + jobType + "]";
	}

	public static class Builder {
		private Identity identity;
		private FullName fullname;
		private Money salary;
		private Iban iban;
		private BirthYear birthYear;
		private Department department;
		private JobType jobType;
		private Photo photo;

		public Builder(Identity identity) {
			this.identity = identity;
		}

		public Builder fullname(String first, String last) {
			this.fullname = FullName.of(first, last);
			return this;
		}

		public Builder fullname(String fullname) {
			var tokens = fullname.split(" ");
			if (tokens.length != 2)
				throw new IllegalArgumentException("does not match: firstname lastname");
			this.fullname = FullName.of(tokens[0], tokens[1]);
			return this;
		}

		public Builder salary(double value, Currency currency) {
			this.salary = Money.of(value, currency);
			return this;
		}

		public Builder iban(String value) {
			this.iban = Iban.valueOf(value);
			return this;
		}

		public Builder birthYear(int value) {
			this.birthYear = BirthYear.valueOf(value);
			return this;
		}

		public Builder photo(byte[] data) {
			this.photo = Photo.of(data);
			return this;
		}

		public Builder jobType(String value) {
			this.jobType = JobType.valueOf(value);
			return this;
		}

		public Builder department(String value) {
			this.department = Department.valueOf(value);
			return this;
		}

		public Employee build() {
			// validation
			// business rule
			return new Employee(this);
		}
	}

}
