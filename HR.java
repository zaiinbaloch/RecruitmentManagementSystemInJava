package recruitmentmanagement;

import java.util.List;
import java.util.Scanner;

class HR extends Applicant {
    private String teamName;
    private HiringDepartment hiringDepartment; //association ki hai ye


    public HR(int id, String name, String email, String phone, String address, String qualifications, String status, String teamName, HiringDepartment hiringDepartment) {
        super(id, name, email, phone, address, qualifications, status); // Applicant constructor ka constructor call horha hai
        this.teamName = teamName;
        this.hiringDepartment = hiringDepartment;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean login() {
        Scanner s = new Scanner(System.in);
        final String Username = "HumanResource";
        final String Password = "123456";
        System.out.println("Login to access HR department of Recruitment System\n");
        System.out.println("-Sign in-\n");

        System.out.print("Enter Username: ");
        String username = s.nextLine();

        System.out.print("Enter Password: ");
        String password = s.nextLine();

        if (username.equals(Username) && password.equals(Password)) {
            System.out.println("\nAccess granted. Welcome to HR department of Recruitment System.");
            System.out.println("Assigned Team: " + teamName + "\n");
            return true;
        } else {
            System.out.println("Invalid Credentials");
            return false;
        }
    }

    //Applicant ki Details dekhny k liye
    public void viewApplicants(List<Applicant> applicants) {
        System.out.println("\n--- Applicant Details ---");
        if (applicants.isEmpty()) {
            System.out.println("No applicants found.");
        } else {
            for (Applicant applicant : applicants) {
                applicant.displayApplicantDetails();
                System.out.println("------------------------");
            }
        }
    }

    //Hr hiring department ka method use kr rha hai status update krny k liye
    public void updateApplicantStatus(List<Applicant> applicants) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Applicant ID to update status: ");
        int applicantId = s.nextInt();
        s.nextLine(); // Consume newline
        System.out.print("Enter New Status (Selected/Rejected/Pending): ");
        String status = s.nextLine();

        //hiring depatment ka method call horha hai taky satus update kia ja saky
        hiringDepartment.updateApplicantStatus(applicants, applicantId, status);
    }
}
