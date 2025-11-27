# Copilot / AI agent instructions for SysVentas

This project is a JavaFX desktop UI backed by Spring Boot and SQLite. The app bootstraps JavaFX and a Spring `ApplicationContext` together (see `SysVentasApplication.java`). Below are focused, actionable notes to help an AI agent make correct and productive edits.

1) Big-picture architecture
- UI: JavaFX FXML files in `src/main/resources/view/` and CSS in `src/main/resources/css/`.
- Controllers: Spring-managed controllers under `src/main/java/.../controller/`. FXML is loaded with `FXMLLoader` and `loader.setControllerFactory(applicationContext::getBean)` in `SysVentasApplication.init()` so controllers must be Spring beans (use `@Controller` / `@Component`).
- Services/DAO: business logic lives in `service/` and `repository/` packages; controllers call service interfaces (e.g. `IUsuarioService`, `ProductoIService`).
- Persistence: SQLite database stored at `data/sysventas.db`, configured in `application.properties` (Hibernate + `org.hibernate.community.dialect.SQLiteDialect`).
- Utilities & components: reusable UI helpers in `components/` (e.g. `TableViewHelper`, `ComboBoxAutoComplete`, `Toast`, `StageManager`). Favor reusing these helpers for consistent UI behavior.

2) Key files to reference when editing
- `src/main/java/pe/edu/upeu/sysventas/SysVentasApplication.java` — JavaFX + Spring bootstrapping and FXML loading pattern.
- `src/main/java/pe/edu/upeu/sysventas/RunJavaFx.java` — simple launcher that calls the JavaFX app.
- `src/main/resources/application.properties` — DB path, Hibernate config, and logging files.
- `src/main/resources/view/*.fxml` — FXML views (e.g. `login.fxml`, `maingui.fxml`, `main_producto.fxml`).
- `src/main/java/pe/edu/upeu/sysventas/controller/*` — controllers loaded as Spring beans.
- `src/main/java/pe/edu/upeu/sysventas/components/*` — common UI helpers to reuse.
- `data/sysventas.db` and `logs/` — runtime DB and logs (do not delete during tests unless intentionally resetting state).

3) Common patterns and constraints (project-specific)
- Always let Spring construct controllers for FXML: do not `new` controllers and set them on the FXMLLoader. Use `loader.setControllerFactory(applicationContext::getBean)` as shown in `SysVentasApplication`.
- Session state is held in a simple singleton DTO: `dto/SessionManager.java` (use `SessionManager.getInstance()` where needed).
- UI menus are dynamically created from DB via `IMenuMenuItemDao`. To add menu entries, update the DAO-backed configuration or sample data rather than hard-coding menus in controllers.
- Reuse `components/*` for consistent UI behavior (toasts, table helpers, auto-complete). New UI features should integrate these helpers instead of reimplementing.

4) Build / run / test commands (Windows PowerShell examples)
- Build (uses the included Maven wrapper):
```
.\mvnw clean package
```
- Run tests:
```
.\mvnw test
```
- Run from IDE: set the main class to `pe.edu.upeu.sysventas.RunJavaFx` or `pe.edu.upeu.sysventas.SysVentasApplication` (RunJavaFx delegates to the JavaFX launcher). This is the recommended development workflow because JavaFX runtime integration varies by environment.
- Run packaged jar (may require JavaFX SDK on module path). Example (PowerShell):
```
.\mvnw clean package
java --module-path "C:\path\to\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml -jar target\SysVentas-0.0.1-SNAPSHOT.jar
```
- spring-boot:run: possible but not guaranteed to start JavaFX UI reliably. If used, set the main class to the launcher: 
```
.\mvnw spring-boot:run -Dspring-boot.run.main-class=pe.edu.upeu.sysventas.RunJavaFx
```

5) Integration points & external dependencies
- SQLite (`org.xerial:sqlite-jdbc`) — DB file `data/sysventas.db` and `application.properties`.
- JavaFX (`org.openjfx:javafx-controls`, `javafx-fxml`) — UI runtime.
- JasperReports + jrviewer-fx — reporting integrations (`net.sf.jasperreports`, `jrviewer-fx`).
- Apache POI / Groovy — Excel import features.
- Gson / jsoup — JSON and HTML parsing utilities.

6) Edits the AI should take care with
- Do not change FXML controller wiring without updating the controllerFactory usage in `SysVentasApplication`.
- Avoid modifying `application.properties` DB path or logging defaults unless intentional; tests and local runs rely on `data/` and `logs/` relative paths.
- When adding new controllers, annotate with `@Controller` and ensure FXML uses the fully-qualified controller class name (or let Spring inject via factory when the FXML file omits fx:controller).

7) Quick examples (how to add a new view)
- Add `src/main/resources/view/my_view.fxml`.
- Create `src/main/java/.../controller/MyViewController.java` with `@Controller` and `@FXML` members.
- Load it from another controller using:
```java
FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/my_view.fxml"));
loader.setControllerFactory(applicationContext::getBean);
Parent root = loader.load();
```

If anything here is unclear or you want additional examples (e.g., how menus are persisted/seeded, or how to run a headless test), tell me which area to expand and I will iterate. 
