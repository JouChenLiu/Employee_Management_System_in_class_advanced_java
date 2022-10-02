//�B�X�� 108403501 ��ޤTA
package employee;

import java.util.*;

class Employee { // �����OEmployee(�Ҧ����u)
	String name;
	String position;
	int salary;

	public void sumSalary(int s) { // �H�򥻮��~�p�⪺(Intern)
		salary = 80 * s;
	}

	public void sumSalary() { // �D�H�򥻮��~�p�⪺
	}

	public void display() {
		System.out.println("�m�W:" + name + " ¾��:" + position + " ���~:" + salary + "\n");
	}
}

class Intern extends Employee { // �l���OIntern
	@Override
	public void sumSalary(int s) {
		super.salary = 80 * s;
	}
}

class NormalEmployee extends Employee { // �l���ONormalEmployee
	@Override
	public void sumSalary() {
		super.sumSalary();
	}
}

class Manager extends Employee { // �l���OManager
	@Override
	public void sumSalary() {
		super.sumSalary();
	}
}

public class Main { // �D���O
	static Scanner sc = new Scanner(System.in); // ��J��ƪ�����
	static Employee[] em = new Employee[100]; // ���u��ƪ�����}�C(���]100��)
	static int iCount = 0; // �����x�s����

	public static void main(String[] args) { // �D�{��

		while (true) {
			System.out.print("�п�J���O:");
			String func = sc.next(); // ��J���O�A�s���r��(�@���P�_���O���ܼ�)

			switch (func) { // �ܼ�func(�P�_��J�����O)
			case "add": // �ݩ�"add"�����O
				System.out.println("�z��J�����O��" + "add");
				addEmployee();
				System.out.println("���u�s�W���\");
				iCount = iCount + 1; // �`����+1
				break;
			case "delete": // �ݩ�"delete"�����O
				System.out.println("�z��J�����O��" + "delete");
				deleteEmployee();
				break;
			case "list": // �ݩ�"list"�����O
				System.out.println("�z��J�����O��" + "list");
				listEmployee();
				break;
			case "edit": // �ݩ�"edit"�����O
				System.out.println("�z��J�����O��" + "edit");
				editEmployee();
				System.out.println("��Ƨ�ʦ��\");
				break;
			default: // ���O��J���~
				System.out.println("�Э��s��J���O");
				break;
			}

		}

	}

	public static void addEmployee() {
		System.out.println("�п�J���u�����O 1.Intern 2.NormalEmployee 3.Manager");
		int aC = sc.nextInt();
		if ((aC != 1) && (aC != 2) && (aC != 3)) { // ��J���O���~�A���s��J
			System.out.println("�Э��s��J���O");
			addEmployee();
		} else {
			System.out.print("�п�J���u���W�r:");
			String aName = sc.next();

			if (aC == 1) { // �P�_��J�����u���O[Intern]
				Employee a = new Intern(); // �ŧi�ëإ�a����
				a.name = aName; // �]�wa�����ݩʭ�
				a.position = "Intern";
				a.salary = 160;
				a.sumSalary(160);
				em[iCount] = a; // �Na������(Intern)�]��Jem����}�C(�Ҧ����uemployee)

			} else if (aC == 2) { // �P�_��J�����u���O[NormalEmployee]
				Employee b = new NormalEmployee(); // �ŧi�ëإ�b����
				b.name = aName; // �]�wb�����ݩʭ�
				b.position = "NormalEmployee";
				b.salary = 30000;
				b.sumSalary();
				em[iCount] = b; // �Nb������(NormalEmployee)�]��Jem����}�C(�Ҧ����uemployee)

			} else if (aC == 3) { // �P�_��J�����u���O[Manager]
				Employee c = new Manager(); // �ŧi�ëإ�c����
				c.name = aName; // �]�wc�����ݩʭ�
				c.position = "Manager";
				c.salary = 50000;
				c.sumSalary();
				em[iCount] = c; // �Nc������(Manager)�]��Jem����}�C(�Ҧ����uemployee)

			}
		}
	}

	public static void deleteEmployee() {
		System.out.print("�п�J�Q�R�������u�W�r:");
		String dName = sc.next();

		int flag = 0, r = 0;
		while (r < iCount) { // �P�_�O�_���o����u(�W�ٿ�J���~)
			if (em[r].name.equals(dName)) {
				flag = 1;
				break;
			}
			r = r + 1;
		}

		if (flag == 0) { // �p�G�S���o����u(�W�ٿ�J���~)
			System.out.println("�L�����u");
		} else {
			for (int i = r; i < iCount; i++) {
				em[i] = em[i + 1]; // �R����r����ơA�N�᭱����Ʃ��e���@�Ӧ�m
			}
			iCount = iCount - 1; // �`����-1
			System.out.println("�R�����\");
		}
	}

	public static void listEmployee() {
		for (int i = 0; i < iCount; i++) {
			em[i].display();
		}
	}

	public static void editEmployee() {
		System.out.print("�п�J�Q��諸���u�m�W:");
		String eName = sc.next();

		int flag = 0, z = 0;
		while (z < iCount) { // �P�_�O�_���o����u(�W�ٿ�J���~)
			if (em[z].name.equals(eName)) {
				flag = 1;
				break;
			}
			z = z + 1;
		}

		if (flag == 0) { // �p�G�S���o����u(�W�ٿ�J���~)
			System.out.println("�L�����u�A�Э��s��J�Q��諸���u�m�W");
			editEmployee();
		} else {
			System.out.println("�п�J�Q��諸����: 1.�m�W 2.�~��");
			int eC = sc.nextInt();

			if ((eC != 1) && (eC != 2)) { // ���O��J���~
				System.out.println("�Э��s��J���O");
				editEmployee();
			} else {
				switch (eC) {
				case 1: // ���m�W
					System.out.print("�п�J�s�W�r:");
					String nName = sc.next();
					em[z].name = nName;
					break;
				case 2: // ����~��
					System.out.print("�п�J�s���~��:");
					int nSalary = sc.nextInt();
					if (em[z].position.equals("Intern")) { // �H�򥻮��~�p�⪺
						em[z].sumSalary(nSalary);
					} else { // �D�H�򥻮��~�p�⪺
						em[z].salary = nSalary;
					}
					break;
				}
			}
		}
	}

}
