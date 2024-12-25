package recruitmentmanagement;

import java.util.List;
import java.util.Scanner;

class HiringDepartment {


    public boolean login() {
        Scanner s = new Scanner(System.in);
        final String Username = "HiringDepartment";
        final String Password = "123456";
        System.out.println("Login to access Hiring Department of Recruitment System\n");
        System.out.println("-Sign in-\n");

        System.out.print("Enter Username: ");
        String username = s.nextLine();

        System.out.print("Enter Password: ");
        String password = s.nextLine();

        if (username.equals(Username) && password.equals(Password)) {
            System.out.println("\nAccess granted to Hiring Department of Recruitment System.");
            return true;
        } else {
            System.out.println("Invalid Credentials");
            return false;
        }
    }

    //applicant ka status update krny k liye
    public void updateApplicantStatus(List<Applicant> applicants, int applicantId, String status) {
        for (Applicant applicant : applicants) {
            if (applicant.getId() == applicantId) {
                applicant.setStatus(status);
                System.out.println("Status updated for applicant: " + applicant.getName());
                return;
            }
        }
        System.out.println("Applicant not found.");
    }
}
