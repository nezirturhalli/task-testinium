FROM openjdk:17
COPY --from=build target/*.jar student-grade-management-system.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "student-grade-management-system.jar"]