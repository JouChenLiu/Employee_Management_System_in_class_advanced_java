//劉柔辰 108403501 資管三A
package employee;

import java.util.*;

class Employee { // 父類別Employee(所有員工)
	String name;
	String position;
	int salary;

	public void sumSalary(int s) { // 以基本時薪計算的(Intern)
		salary = 80 * s;
	}

	public void sumSalary() { // 非以基本時薪計算的
	}

	public void display() {
		System.out.println("姓名:" + name + " 職等:" + position + " 月薪:" + salary + "\n");
	}
}

class Intern extends Employee { // 子類別Intern
	@Override
	public void sumSalary(int s) {
		super.salary = 80 * s;
	}
}

class NormalEmployee extends Employee { // 子類別NormalEmployee
	@Override
	public void sumSalary() {
		super.sumSalary();
	}
}

class Manager extends Employee { // 子類別Manager
	@Override
	public void sumSalary() {
		super.sumSalary();
	}
}

public class Main { // 主類別
	static Scanner sc = new Scanner(System.in); // 輸入資料的物件
	static Employee[] em = new Employee[100]; // 員工資料的物件陣列(假設100筆)
	static int iCount = 0; // 紀錄儲存筆數

	public static void main(String[] args) { // 主程式

		while (true) {
			System.out.print("請輸入指令:");
			String func = sc.next(); // 輸入指令，存成字串(作為判斷指令的變數)

			switch (func) { // 變數func(判斷輸入的指令)
			case "add": // 屬於"add"的指令
				System.out.println("您輸入的指令為" + "add");
				addEmployee();
				System.out.println("員工新增成功");
				iCount = iCount + 1; // 總筆數+1
				break;
			case "delete": // 屬於"delete"的指令
				System.out.println("您輸入的指令為" + "delete");
				deleteEmployee();
				break;
			case "list": // 屬於"list"的指令
				System.out.println("您輸入的指令為" + "list");
				listEmployee();
				break;
			case "edit": // 屬於"edit"的指令
				System.out.println("您輸入的指令為" + "edit");
				editEmployee();
				System.out.println("資料更動成功");
				break;
			default: // 指令輸入錯誤
				System.out.println("請重新輸入指令");
				break;
			}

		}

	}

	public static void addEmployee() {
		System.out.println("請輸入員工的類別 1.Intern 2.NormalEmployee 3.Manager");
		int aC = sc.nextInt();
		if ((aC != 1) && (aC != 2) && (aC != 3)) { // 輸入指令錯誤，重新輸入
			System.out.println("請重新輸入指令");
			addEmployee();
		} else {
			System.out.print("請輸入員工的名字:");
			String aName = sc.next();

			if (aC == 1) { // 判斷輸入的員工類別[Intern]
				Employee a = new Intern(); // 宣告並建立a物件
				a.name = aName; // 設定a物件的屬性值
				a.position = "Intern";
				a.salary = 160;
				a.sumSalary(160);
				em[iCount] = a; // 將a物件資料(Intern)也放入em物件陣列(所有員工employee)

			} else if (aC == 2) { // 判斷輸入的員工類別[NormalEmployee]
				Employee b = new NormalEmployee(); // 宣告並建立b物件
				b.name = aName; // 設定b物件的屬性值
				b.position = "NormalEmployee";
				b.salary = 30000;
				b.sumSalary();
				em[iCount] = b; // 將b物件資料(NormalEmployee)也放入em物件陣列(所有員工employee)

			} else if (aC == 3) { // 判斷輸入的員工類別[Manager]
				Employee c = new Manager(); // 宣告並建立c物件
				c.name = aName; // 設定c物件的屬性值
				c.position = "Manager";
				c.salary = 50000;
				c.sumSalary();
				em[iCount] = c; // 將c物件資料(Manager)也放入em物件陣列(所有員工employee)

			}
		}
	}

	public static void deleteEmployee() {
		System.out.print("請輸入想刪除的員工名字:");
		String dName = sc.next();

		int flag = 0, r = 0;
		while (r < iCount) { // 判斷是否有這位員工(名稱輸入錯誤)
			if (em[r].name.equals(dName)) {
				flag = 1;
				break;
			}
			r = r + 1;
		}

		if (flag == 0) { // 如果沒有這位員工(名稱輸入錯誤)
			System.out.println("無此員工");
		} else {
			for (int i = r; i < iCount; i++) {
				em[i] = em[i + 1]; // 刪除第r筆資料，將後面的資料往前移一個位置
			}
			iCount = iCount - 1; // 總筆數-1
			System.out.println("刪除成功");
		}
	}

	public static void listEmployee() {
		for (int i = 0; i < iCount; i++) {
			em[i].display();
		}
	}

	public static void editEmployee() {
		System.out.print("請輸入想更改的員工姓名:");
		String eName = sc.next();

		int flag = 0, z = 0;
		while (z < iCount) { // 判斷是否有這位員工(名稱輸入錯誤)
			if (em[z].name.equals(eName)) {
				flag = 1;
				break;
			}
			z = z + 1;
		}

		if (flag == 0) { // 如果沒有這位員工(名稱輸入錯誤)
			System.out.println("無此員工，請重新輸入想更改的員工姓名");
			editEmployee();
		} else {
			System.out.println("請輸入想更改的項目: 1.姓名 2.薪資");
			int eC = sc.nextInt();

			if ((eC != 1) && (eC != 2)) { // 指令輸入錯誤
				System.out.println("請重新輸入指令");
				editEmployee();
			} else {
				switch (eC) {
				case 1: // 更改姓名
					System.out.print("請輸入新名字:");
					String nName = sc.next();
					em[z].name = nName;
					break;
				case 2: // 更改薪資
					System.out.print("請輸入新的薪資:");
					int nSalary = sc.nextInt();
					if (em[z].position.equals("Intern")) { // 以基本時薪計算的
						em[z].sumSalary(nSalary);
					} else { // 非以基本時薪計算的
						em[z].salary = nSalary;
					}
					break;
				}
			}
		}
	}

}
