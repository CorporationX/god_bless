package school.faang.bjs244933;

import lombok.NonNull;
import lombok.val;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static final String DESIGNER = "designer";
    public static final String FRONTEND_DEVELOPER = "frontend developer";
    public static final String BACKEND_DEVELOPER = "backend developer";
    public static final String PROJECT_MANAGER = "project manager";
    public static final String ANALYST = "analyst";
    private static final String TESTER = "tester";

    public static void main(String[] args) {

        Set<String> skillsBob = getSkillsBob();
        Set<String> skillsTom = getSkillsTom();
        Set<String> skillsAlice = getSkillsAlice();
        Set<String> skillsEva = getEva();
        Set<String> skillsArnold = getArnold();

        Employee bob = new Employee(1, "Bob", skillsBob);
        Employee tom = new Employee(2, "Tom", skillsTom);
        Employee alice = new Employee(3, "Alice", skillsAlice);
        Employee eva = new Employee(4, "Eve", skillsEva);
        Employee arnold = new Employee(5, "Arnold", skillsArnold);

        Set<String> requiredSkillsDatingSite = getRequiredSkillsDatingSite();
        Set<String> requiredSkillsBilling = getRequiredSkillsBilling();

        Project projectDatingSite =
                new Project(1, "A dating site", requiredSkillsDatingSite, new ArrayList<>());

        Project projectBilling =
                new Project(2, "Billing project", requiredSkillsBilling, new ArrayList<>());

        List<Employee> employees = new ArrayList<>();
        employees.add(bob);
        employees.add(tom);
        employees.add(alice);
        employees.add(eva);

        Map<Integer, Project> projects = new HashMap<>();
        projects.put(1, projectDatingSite);
        projects.put(2, projectBilling);

        ProjectManager projectManager = new ProjectManager(employees, projects);
        TeamAssignmentStrategy standardTeamAssignmentStrategy = new StandardTeamAssignmentStrategy();

        System.out.println("----------------------- A dating site -- standardTeamAssignmentStrategy");
        projectManager.setAssignmentStrategy(standardTeamAssignmentStrategy);
        projectManager.assignTeamToProject(1);
        System.out.println(projectDatingSite.getTeamMembers());

        System.out.println("----------------------  A dating site -- balancedTeamAssignmentStrategy");

        TeamAssignmentStrategy balancedTeamAssignmentStrategy = new BalancedTeamAssignmentStrategy();
        projectManager.setAssignmentStrategy(balancedTeamAssignmentStrategy);
        projectManager.assignTeamToProject(1);
        System.out.println(projectManager.getTeamForProject(1));

        System.out.println("------- removeEmployeeFromProject - projectDatingSite ----------------");

        projectManager.removeEmployeeFromProject(1, 1);
        val isAdd = projectManager.assignEmployeeToProject(1, arnold);
        System.out.println(projectManager.getTeamMembers(1) + ", isAdd: " + isAdd);

        System.out.println("--------------------- Billing project --------------------------------");
        projectManager.setAssignmentStrategy(standardTeamAssignmentStrategy);
        projectManager.assignTeamToProject(2);
        System.out.println(projectBilling.getTeamMembers());

        System.out.println("----------------------------------------------------------------------");
        projectManager.addEmployee(arnold);
        projectManager.findProjectsForEmployee(arnold).forEach(v -> System.out.println("Arnold: " + v.getName()));

        System.out.println("----------------------------------------------------------------------");
        Project projectBillingNew =
                new Project(3, "Billing project New", requiredSkillsDatingSite, new ArrayList<>());
        projectManager.removeIneligibleEmployees(projectBillingNew);
        System.out.println(projectBillingNew.getTeamMembers());
    }

    private static Set<String> getArnold() {
        Set<String> skills = new HashSet<>();
        skills.add(DESIGNER);
        skills.add(FRONTEND_DEVELOPER);
        skills.add(PROJECT_MANAGER);
        skills.add(TESTER);
        return skills;
    }

    private static Set<String> getEva() {
        Set<String> skills = new HashSet<>();
        skills.add(TESTER);
        return skills;
    }

    private static Set<String> getRequiredSkillsBilling() {
        Set<String> requiredSkills = new HashSet<>();
        requiredSkills.add(DESIGNER);
        requiredSkills.add(FRONTEND_DEVELOPER);
        requiredSkills.add(PROJECT_MANAGER);
        requiredSkills.add(TESTER);
        return requiredSkills;
    }

    private static Set<String> getRequiredSkillsDatingSite() {
        Set<String> requiredSkills = new HashSet<>();
        requiredSkills.add(DESIGNER);
        requiredSkills.add(FRONTEND_DEVELOPER);
        requiredSkills.add(PROJECT_MANAGER);
        return requiredSkills;
    }

    private static Set<String> getSkillsAlice() {
        Set<String> skillsAlice = new HashSet<>();
        skillsAlice.add(PROJECT_MANAGER);
        skillsAlice.add(ANALYST);
        return skillsAlice;
    }

    private static Set<String> getSkillsTom() {
        Set<String> skillsTom = new HashSet<>();
        skillsTom.add(BACKEND_DEVELOPER);
        skillsTom.add(FRONTEND_DEVELOPER);
        return skillsTom;
    }

    private static Set<String> getSkillsBob() {
        Set<String> skillsBob = new HashSet<>();
        skillsBob.add(DESIGNER);
        skillsBob.add(FRONTEND_DEVELOPER);
        return skillsBob;
    }
}
