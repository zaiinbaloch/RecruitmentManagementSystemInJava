
package recruitmentmanagement;

import java.util.*;


public class RecruitmentManagement {
    private static Object hrChoice;
    public static void main(String[] args) {
        // Initialize instances
        Job j = new Job("", "", 0);
        Applicant ap = new Applicant(0, "", "", "", "", "", "");
        Admin a = new Admin();
        HiringDepartment HD = new HiringDepartment();

        HR h = new HR(1, "", "", "", "", "", "", "", HD);

        Menus m = new Menus();
        Scanner s = new Scanner(System.in);
        
        //ye code sirf file create krny k liye tha
        File jobFile = new File("Job.txt");
        File ApplicantFile = new File("Applicant.txt");
       try {
            if (ApplicantFile.createNewFile()){
                System.out.println("File created :"+ApplicantFile.getName());    
            }else{
                System.out.println("File already exist");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }        
       
       try {
            if (jobFile.createNewFile()) {
                System.out.println("File created: " + jobFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //jobs or applicants ki Files ky path  
        String jobFile = "Job.txt";
        String applicantFile = "Applicant.txt";

        //agr file mai koi data hai toh usko load krny k liye
        List<Job> jobs = Job.readJobsFromFile(jobFile);
        List<Applicant> applicants = Applicant.readApplicantsFromFile(applicantFile);

        while (true) {
            
            m.stakeholders();
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1: // Admin ka case
                    if (!a.login()) {
                        System.out.println("Access Denied, Exiting...");
                        return; // Agr login fail hogaya toh program Exit hojye ga yahan
                    }

                    while (true) {
                        m.Adminmenu();
                        choice = s.nextInt();
                        s.nextLine();

                        switch (choice) {
                            case 1: // Job Management k liye case
                                String jobOption;
                                do {
                                    m.jobmenu();
                                    choice = s.nextInt();
                                    s.nextLine();

                                    switch (choice) {
                                        case 1: // Add Job details
                                            j.addJob();
                                            jobs.add(j);
                                            Job.writeJobsToFile(jobs, jobFile);
                                            break;

                                        case 2: // Display All Jobs details
                                            Job.displayJobs(jobs);
                                            break;

                                        case 3: // Update Job details
                                            Job.updateJob(jobs);
                                            Job.writeJobsToFile(jobs, jobFile);
                                            break;

                                        case 4: // Delete Job details
                                            Job.deleteJob(jobs);
                                            Job.writeJobsToFile(jobs, jobFile);
                                            break;

                                        default:
                                            System.out.println("Invalid Option Selected.");
                                    }

                                    System.out.println("Continue in Job Menu? Enter YES to continue or NO to return to Main Menu.");
                                    jobOption = s.nextLine();

                                } while (jobOption.equalsIgnoreCase("YES"));
                                break;

                            case 2: // Applicant Management k liye case
                                String applicantOption;
                                do {
                                    m.applicantmenu();
                                    choice = s.nextInt();
                                    s.nextLine();

                                    switch (choice) {
                                        case 1: // Add Applicant details
                                            ap.addApplicant();
                                            applicants.add(ap);
                                            Applicant.writeApplicantsToFile(applicants, applicantFile);
                                            break;

                                        case 2: // Display All Applicants details
                                            Applicant.displayAllApplicants(applicants);
                                            break;

                                        case 3: // Update Applicant details
                                            Applicant.updateApplicant(applicants);
                                            Applicant.writeApplicantsToFile(applicants, applicantFile);
                                            break;

                                        case 4: // Delete Applicant details
                                            Applicant.deleteApplicant(applicants);
                                            Applicant.writeApplicantsToFile(applicants, applicantFile);
                                            break;

                                        default:
                                            System.out.println("Invalid Option Selected.");
                                    }

                                    System.out.println("Continue in Applicant Menu? Enter YES to continue or NO to return to Main Menu.");
                                    applicantOption = s.nextLine();

                                } while (applicantOption.equalsIgnoreCase("YES"));
                                break;

                            case 3:
                                System.out.println("Signing off. Returning to Stakeholder Menu...");
                                break; 
                                
                            default:
                                System.out.println("Invalid Option Selected.");
                        }

                        if (choice == 3) break;
                    }
                    break;

                case 2: // HR ka case
                    if (!h.login()) {
                        System.out.println("Access Denied, Exiting...");
                        return; // Agr login fail hogaya toh program Exit hojye ga yahan
                    }

                    // HR applicants ki details dekh skta hai or unka status update kr skta hai
                    do {
                       m.HRmenu();
                        String hrChoice = s.nextLine();
                        switch (hrChoice) {
                            case "1":
                                h.viewApplicants(applicants);
                                break;
                            case "2":
                                h.updateApplicantStatus(applicants);
                                break;
                            case "3":
                                System.out.println("HR Team :" + h.getTeamName());
                                break; 
                            case "4":
                                System.out.println("Signing off. Returning to Stakeholder Menu...");
                                break; 
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    } while (!hrChoice.equals("4"));
                    break;

                case 3: // Hiring Department ka case
                    if (!HD.login()) {
                        System.out.println("Access Denied, Exiting...");
                        return; // Agr login fail hogaya toh program Exit hojye ga yahan 
                    }
                    m.HiringDepartmentmenu();
                    choice = s.nextInt();
                    s.nextLine();
                        switch (choice) {
                            case 1:
                                h.viewApplicants(applicants);
                                break;
                            case 2:
                                h.updateApplicantStatus(applicants);
                                break;
                            case 3:
                                System.out.println("Signing off. Returning to Stakeholder Menu...");
                                break; 
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    break;
                 
                 case 4:
                     System.out.println("Shutting Down...");
                     System.exit(0);

                default:
                    System.out.println("Invalid Stakeholder Option Selected. Exiting...");
                    return; // Agar selection invalid hoi program exit hojye ga
            }
        }
    }
}
