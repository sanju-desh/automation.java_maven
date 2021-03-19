package org.automation;
// Java program to demonstrate working of Comparator
// interface

import java.util.Comparator;

// A class to represent a student.
class Student
{
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name,
                   String address)
    {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Used to print student details in main()
    public String toString()
    {
        return this.rollno + " " + this.name +
                " " + this.address;
    }
}

class Sortbyroll implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}

class Sortbyname implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // name
    public int compare(Student a, Student b)
    {
        return a.name.compareTo(b.name);
    }
}

// Driver class
class Main
{
    public static void main (String[] args)
    {

        /*
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new Sortbyroll());

        System.out.println("\nSorted by rollno");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new Sortbyname());

        System.out.println("\nSorted by name");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));


         */
        String mainStr = "Christopher Sathish Swamy Doss";
        String[] str = mainStr.toLowerCase().split(" ");
        int vCount = 0, aC = 0, eC = 0, iC = 0, oC = 0, uC = 0;
        for(String s : str) {
            boolean flag = false;
            for (char a : s.toCharArray()) {
                if (Character.compare('a', a) == 0) {
                    vCount = vCount + 1;
                    aC = aC + 1;
                    flag = true;
                } else if (Character.compare('e', a) == 0) {
                    vCount = vCount + 1;
                    eC = eC + 1;
                    flag = true;
                } else if (Character.compare('i', a) == 0) {
                    vCount = vCount + 1;
                    iC = iC + 1;
                    flag = true;
                } else if (Character.compare('o', a) == 0) {
                    vCount = vCount + 1;
                    oC = oC + 1;
                    flag = true;
                } else if (Character.compare('u', a) == 0) {
                    vCount = vCount + 1;
                    uC = uC + 1;
                    flag = true;
                }
            }
            if (flag)
                System.out.println("Word " + s + " has vowels in it!");
        }
        System.out.println("Total number of vowels is: "+vCount);
        System.out.println("Total number of times a exist: "+aC);
        System.out.println("Total number of times e exist: "+eC);
        System.out.println("Total number of times i exist: "+iC);
        System.out.println("Total number of times o exist: "+oC);
        System.out.println("Total number of times u exist: "+uC);
    }
}
