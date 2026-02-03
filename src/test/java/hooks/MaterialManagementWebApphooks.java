package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinations.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

public class MaterialManagementWebApphooks extends BaseClass {

//    @Before
//    public void setup() throws IOException {
//        // Reading the properties file
//        configprop = new Properties();
//        String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
//        FileInputStream configProfile = new FileInputStream(configPath);
//        configprop.load(configProfile);
//
//
//        // Logger setup
//        logger = Logger.getLogger("WorkRoomWebApplication");
//        String log4jPath = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
//        PropertyConfigurator.configure(log4jPath);
//        logger.setLevel(Level.DEBUG);
//
//
//        String br = configprop.getProperty("browser"); //getting the browser name from config.properties file
//
//        //Launching browser
//        if (br.equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxdriverpath"));
//            driver = new FirefoxDriver();
//        } else if (br.equals("chrome")) {
//
//            logger.info("************* Launching CHROME Browser *****************");
//            ChromeOptions options = new ChromeOptions();
//          //  options.addArguments("--headless=new");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--remote-allow-origins=*");
//            String userDataDir = "/tmp/chrome-user-data-" + UUID.randomUUID();
//            options.addArguments("--user-data-dir=" + userDataDir);
//
//
//
//            System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
//            driver = new ChromeDriver(options);
//        } else if (br.equals("msedge")) {
//            logger.info("************* Launching EDGE Browser *****************");
//            System.setProperty("webdriver.edge.driver", configprop.getProperty("microsoftedgepath"));
//            // Create EdgeOptions to start a fresh session
//            EdgeOptions options = new EdgeOptions();
//            options.addArguments("--no-sandbox"); // Ensures Edge runs safely
//            options.addArguments("--disable-dev-shm-usage"); // Fixes resource issues on Linux
//            options.addArguments("--disable-gpu"); // Disables GPU rendering
//            options.addArguments("--remote-allow-origins=*"); // Resolves security policy issues
//            options.addArguments("--guest"); // Launches without user profile
//            driver = new EdgeDriver(options); // Launch Edge
//        }
//        // Maximize the browser window
//        logger.info("************* Browser Launched and Maximized *****************");
//        driver.manage().window().maximize();
//
//
//    }
//    @After
//    public void tearDown(Scenario scenario) {
//        try {
//            if (scenario.isFailed()) {
//                // Take a screenshot if scenario fails
//                if (driver != null) {
//                    TakesScreenshot ts = (TakesScreenshot) driver;
//                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//
//                    scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
//                    // Also attach to Allure report
//                    //  Allure.addAttachment("Allure Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
//
//
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Failed to capture screenshot: " + e.getMessage());
//        }
////        finally {
////            if (driver != null) {
////                logger.info("************* Quitting Browser *****************");
////                driver.quit(); // This closes all windows and ends the WebDriver session
////                logger.info("************* Browser Closed Successfully *****************");
////            }
////        }
//    }

// ********************************* Start ******************************************************************
//   // method 2 to download the  filesinto my project directory

//        @Before
//        public void setup() throws IOException {
//            // Reading the properties file
//            configprop = new Properties();
//            String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
//            FileInputStream configProfile = new FileInputStream(configPath);
//            configprop.load(configProfile);
//
//            // Logger setup
//            logger = Logger.getLogger("WorkRoomWebApplication");
//            String log4jPath = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
//            PropertyConfigurator.configure(log4jPath);
//            logger.setLevel(Level.DEBUG);
//
//            // Create download directory
//            String projectDir = System.getProperty("user.dir");
//            String downloadPath = projectDir + File.separator + "Downloaded Documents";
//            File downloadDir = new File(downloadPath);
//            if (!downloadDir.exists()) {
//                boolean created = downloadDir.mkdirs();
//                logger.info("Created download directory: " + downloadPath + " (success: " + created + ")");
//            } else {
//                logger.info("Download directory already exists: " + downloadPath);
//            }
//
//            String br = configprop.getProperty("browser"); // getting the browser name from config.properties file
//
//            // Launching browser with download configuration
//            if (br.equals("firefox")) {
//                driver = setupFirefoxDriver(downloadPath);
//            } else if (br.equals("chrome")) {
//                driver = setupChromeDriver(downloadPath);
//            } else if (br.equals("msedge")) {
//                driver = setupEdgeDriver(downloadPath);
//            } else {
//                logger.error("Unsupported browser: " + br);
//                throw new IllegalArgumentException("Unsupported browser: " + br);
//            }
//
//            // Set timeouts
//            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
//            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(60));
//            driver.manage().timeouts().scriptTimeout(java.time.Duration.ofSeconds(30));
//
//            // Maximize the browser window
//            logger.info("************* Browser Launched and Maximized *****************");
//            driver.manage().window().maximize();
//        }
//
//        private WebDriver setupChromeDriver(String downloadPath) {
//            logger.info("************* Launching CHROME Browser *****************");
//
//            // Set ChromeDriver path
//            System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
//
//            ChromeOptions options = new ChromeOptions();
//
//            // Configure download preferences
//            Map<String, Object> prefs = new HashMap<>();
//            prefs.put("download.default_directory", downloadPath);
//            prefs.put("download.prompt_for_download", false);
//            prefs.put("download.directory_upgrade", true);
//            prefs.put("safebrowsing.enabled", true);
//            prefs.put("plugins.always_open_pdf_externally", true);
//            prefs.put("profile.default_content_settings.popups", 0);
//            prefs.put("credentials_enable_service", false);
//            prefs.put("profile.password_manager_enabled", false);
//
//            options.setExperimentalOption("prefs", prefs);
//
//            // Add browser arguments
//            String userDataDir = "/tmp/chrome-user-data-" + UUID.randomUUID();
//            options.addArguments("--user-data-dir=" + userDataDir);
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--start-maximized");
//            options.addArguments("--disable-notifications");
//            options.addArguments("--disable-extensions");
//            options.addArguments("--disable-blink-features=AutomationControlled");
//            options.addArguments("--disable-infobars");
//
//            // Uncomment for headless mode if needed
//            // options.addArguments("--headless=new");
//
//            // Add experimental options to avoid detection
//            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//            options.setExperimentalOption("useAutomationExtension", false);
//
//            return new ChromeDriver(options);
//        }
//
//        private WebDriver setupFirefoxDriver(String downloadPath) {
//            logger.info("************* Launching FIREFOX Browser *****************");
//
//            // Set FirefoxDriver path
//            System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxdriverpath"));
//
//            FirefoxProfile profile = new FirefoxProfile();
//
//            // Configure Firefox download preferences
//            profile.setPreference("browser.download.folderList", 2); // Use custom download directory
//            profile.setPreference("browser.download.dir", downloadPath);
//            profile.setPreference("browser.download.downloadDir", downloadPath);
//            profile.setPreference("browser.download.defaultFolder", downloadPath);
//            profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
//                    "application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet," +
//                            "application/pdf,application/octet-stream,text/csv,text/plain," +
//                            "application/vnd.ms-excel.sheet.macroEnabled.12");
//            profile.setPreference("browser.download.manager.showWhenStarting", false);
//            profile.setPreference("browser.download.manager.useWindow", false);
//            profile.setPreference("browser.download.manager.focusWhenStarting", false);
//            profile.setPreference("browser.download.manager.showAlertOnComplete", false);
//            profile.setPreference("browser.download.manager.closeWhenDone", true);
//            profile.setPreference("pdfjs.disabled", true); // Disable Firefox's built-in PDF viewer
//
//            FirefoxOptions options = new FirefoxOptions();
//            options.setProfile(profile);
//
//            // Add arguments
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--disable-gpu");
//            options.addArguments("-private"); // Start in private mode
//
//            return new FirefoxDriver(options);
//        }
//
//        private WebDriver setupEdgeDriver(String downloadPath) {
//            logger.info("************* Launching EDGE Browser *****************");
//
//            // Set EdgeDriver path
//            System.setProperty("webdriver.edge.driver", configprop.getProperty("microsoftedgepath"));
//
//            EdgeOptions options = new EdgeOptions();
//
//            // Configure download preferences for Edge
//            Map<String, Object> prefs = new HashMap<>();
//            prefs.put("download.default_directory", downloadPath);
//            prefs.put("download.prompt_for_download", false);
//            prefs.put("download.directory_upgrade", true);
//            prefs.put("safebrowsing.enabled", true);
//            prefs.put("plugins.always_open_pdf_externally", true);
//            prefs.put("profile.default_content_settings.popups", 0);
//
//            options.setExperimentalOption("prefs", prefs);
//
//            // Add arguments
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--guest"); // Launches without user profile
//            options.addArguments("--start-maximized");
//            options.addArguments("--disable-notifications");
//            options.addArguments("--inprivate"); // Start in InPrivate mode
//
//            // Add experimental options
//            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//            options.setExperimentalOption("useAutomationExtension", false);
//
//            return new EdgeDriver(options);
//        }
//
//        @After
//        public void tearDown(Scenario scenario) {
//            try {
//                if (scenario.isFailed()) {
//                    // Take a screenshot if scenario fails
//                    if (driver != null) {
//                        TakesScreenshot ts = (TakesScreenshot) driver;
//                        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//                        scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
//                        logger.error("Scenario failed: " + scenario.getName());
//                    }
//                } else {
//                    logger.info("Scenario passed: " + scenario.getName());
//                }
//
//                // Log downloaded files information
//                logDownloadedFilesInfo();
//
//            } catch (Exception e) {
//                logger.error("Failed to capture screenshot or log files: " + e.getMessage());
//            } finally {
//                if (driver != null) {
//                    logger.info("************* Quitting Browser *****************");
//                    driver.quit(); // This closes all windows and ends the WebDriver session
//                    logger.info("************* Browser Closed Successfully *****************");
//                }
//            }
//        }
//
//        private void logDownloadedFilesInfo() {
//            try {
//                String downloadPath = System.getProperty("user.dir") + File.separator + "Downloaded Documents";
//
//                // ✅ WAIT for download to finish
//                waitForDownloadToComplete(downloadPath, 30);
//                File downloadDir = new File(downloadPath);
//
//                if (downloadDir.exists() && downloadDir.isDirectory()) {
//                    File[] files = downloadDir.listFiles();
//                    if (files != null && files.length > 0) {
//                        logger.info("=== Downloaded Files Summary ===");
//                        logger.info("Download directory: " + downloadPath);
//
//                        for (File file : files) {
//                            if (file.isFile()) {
//                                String fileName = file.getName();
//                                long fileSize = file.length();
//                                String formattedSize = formatFileSize(fileSize);
//                                String lastModified = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                                        .format(new java.util.Date(file.lastModified()));
//
//                                logger.info("File: " + fileName +
//                                        " | Size: " + formattedSize +
//                                        " | Modified: " + lastModified);
//                            }
//                        }
//                        logger.info("Total files: " + files.length);
//                    } else {
//                        logger.info("No files found in download directory");
//                    }
//                }
//            } catch (Exception e) {
//                logger.error("Error logging downloaded files info: " + e.getMessage());
//            }
//        }
//
//        private String formatFileSize(long size) {
//            if (size < 1024) {
//                return size + " bytes";
//            } else if (size < 1024 * 1024) {
//                return String.format("%.2f KB", size / 1024.0);
//            } else {
//                return String.format("%.2f MB", size / (1024.0 * 1024.0));
//            }
//        }
//
//
//    private void waitForDownloadToComplete(String downloadPath, int timeoutSeconds) {
//        File dir = new File(downloadPath);
//        long endTime = System.currentTimeMillis() + timeoutSeconds * 1000;
//
//        while (System.currentTimeMillis() < endTime) {
//            File[] files = dir.listFiles();
//            boolean downloading = false;
//
//            if (files != null) {
//                for (File file : files) {
//                    if (file.getName().endsWith(".crdownload")) {
//                        downloading = true;
//                        break;
//                    }
//                }
//            }
//
//            if (!downloading) {
//                return; // download finished
//            }
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignored) {}
//        }
//
//        throw new RuntimeException("Download did not complete within timeout");
//    }





// ****************************** END *******************************************************************************





//For Docker Image

//    @Before
//    public void setup() throws IOException, MalformedURLException {
//        // Reading the properties file
//        configprop = new Properties();
//        String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
//        FileInputStream configProfile = new FileInputStream(configPath);
//        configprop.load(configProfile);
//
//        // Logger setup
//        logger = Logger.getLogger("WorkRoomWebApplication");
//        String log4jPath = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
//        PropertyConfigurator.configure(log4jPath);
//        logger.setLevel(Level.DEBUG);
//
//        String br = configprop.getProperty("browser");
//        String hubURL = configprop.getProperty("hubURL"); // e.g. http://localhost:4444/wd/hub
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        switch (br.toLowerCase()) {
//            case "chrome":
//                capabilities.setBrowserName("chrome");
////                ChromeOptions chromeOptions = new ChromeOptions();
////                chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--remote-allow-origins=*");
////                // Optional: Headless
////                // chromeOptions.addArguments("--headless=new");
////                driver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
//                break;
//            case "firefox":
//
////                FirefoxOptions firefoxOptions = new FirefoxOptions();
////                firefoxOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
////                driver = new RemoteWebDriver(new URL(hubURL), firefoxOptions);
//                capabilities.setBrowserName("firefox");
//                break;
//            case "edge":
//                capabilities.setBrowserName("MicrosoftEdge");
////                EdgeOptions edgeOptions = new EdgeOptions();
////                edgeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--remote-allow-origins=*");
////                driver = new RemoteWebDriver(new URL(hubURL), edgeOptions);
//                break;
//            default:
//                throw new RuntimeException("Browser not supported: " + br);
//        }
//
//        driver = new RemoteWebDriver(new URL(hubURL), capabilities);
//        logger.info("************* Remote WebDriver Launched *****************");
//        driver.manage().window().maximize();
//    }
//
//
//
//    @After
//    public void tearDown(Scenario scenario) {
//        try {
//            if (scenario.isFailed()) {
//                // Take a screenshot if scenario fails
//                if (driver != null) {
//                    TakesScreenshot ts = (TakesScreenshot) driver;
//                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//
//                    scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
//                    // Also attach to Allure report
//                    //  Allure.addAttachment("Allure Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
//
//
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Failed to capture screenshot: " + e.getMessage());
//        }
//        finally {
//            if (driver != null) {
//                logger.info("************* Quitting Browser *****************");
//                driver.quit(); // This closes all windows and ends the WebDriver session
//                logger.info("************* Browser Closed Successfully *****************");
//            }
//        }
//    }


    // ********************* Start **********************************************

//
        @Before
        public void setup() throws IOException {
            // 1. Load configuration properties
            configprop = new Properties();
            String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(configPath);
            configprop.load(fis);

            // 2. Initialize Logger
            logger = Logger.getLogger("WorkRoomWebApplication");
            String log4jPath = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
            PropertyConfigurator.configure(log4jPath);

            String br = configprop.getProperty("browser").toLowerCase();
            String hubURL = configprop.getProperty("hubURL");

            // This is the standard download path inside the Selenium Docker container
            String containerDownloadPath = "/home/seluser/Downloads";

            // 3. Setup Browser Options for Remote Execution
            switch (br) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    Map<String, Object> chromePrefs = new HashMap<>();
                    chromePrefs.put("download.default_directory", containerDownloadPath);
                    chromePrefs.put("download.prompt_for_download", false);
                    chromePrefs.put("plugins.always_open_pdf_externally", true);
                    chromeOptions.setExperimentalOption("prefs", chromePrefs);
                    chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");

                    driver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addPreference("browser.download.dir", containerDownloadPath);
                    firefoxOptions.addPreference("browser.download.folderList", 2);
                    firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
                            "application/pdf,application/octet-stream,text/csv,application/vnd.ms-excel");
                    firefoxOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");

                    driver = new RemoteWebDriver(new URL(hubURL), firefoxOptions);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    Map<String, Object> edgePrefs = new HashMap<>();
                    edgePrefs.put("download.default_directory", containerDownloadPath);
                    edgePrefs.put("download.prompt_for_download", false);
                    edgeOptions.setExperimentalOption("prefs", edgePrefs);
                    edgeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");

                    driver = new RemoteWebDriver(new URL(hubURL), edgeOptions);
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + br);
            }

            logger.info("************* Remote WebDriver Launched (Docker) *****************");
            driver.manage().window().maximize();
        }

        @After
        public void tearDown(Scenario scenario) {
            try {
                if (scenario.isFailed() && driver != null) {
                    // Capture screenshot on failure
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failed_Step_Screenshot");
                    logger.error("Scenario Failed: " + scenario.getName());
                }
            } catch (Exception e) {
                logger.error("Error in tearDown: " + e.getMessage());
            } finally {
                if (driver != null) {
                    logger.info("************* Quitting Remote Browser *****************");
                    driver.quit();
                }
            }
        }



    // ********************* END  **********************************************





////
////@Before
//public void setup() throws IOException, MalformedURLException {
//    // Load config.properties
//    configprop = new Properties();
//    String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
//    FileInputStream configProfile = new FileInputStream(configPath);
//    configprop.load(configProfile);
//
//    // Logger setup
//    logger = Logger.getLogger("MaterialManagementSharePointApplication");
//    String log4jPath = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
//    PropertyConfigurator.configure(log4jPath);
//    logger.setLevel(Level.DEBUG);
//
//    String br = configprop.getProperty("browser");
//    String hubURL = configprop.getProperty("hubURL"); // e.g. http://localhost:4444/wd/hub
//
//    switch (br.toLowerCase()) {
//        case "chrome":
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless=new"); // Use --headless for older versions
//            chromeOptions.addArguments("--no-sandbox");
//            chromeOptions.addArguments("--disable-dev-shm-usage");
//            chromeOptions.addArguments("--disable-gpu");
//            chromeOptions.addArguments("--remote-allow-origins=*");
//            logger.info("************* Remote WebDriver Launched in Headless Mode *****************");
//            driver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
//            break;
//
//        case "firefox":
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.addArguments("--headless");
//            firefoxOptions.addArguments("--no-sandbox");
//            firefoxOptions.addArguments("--disable-dev-shm-usage");
//
//            driver = new RemoteWebDriver(new URL(hubURL), firefoxOptions);
//            break;
//
//        case "edge":
//            EdgeOptions edgeOptions = new EdgeOptions();
//            edgeOptions.addArguments("--headless=new");
//            edgeOptions.addArguments("--no-sandbox");
//            edgeOptions.addArguments("--disable-dev-shm-usage");
//            edgeOptions.addArguments("--disable-gpu");
//
//            driver = new RemoteWebDriver(new URL(hubURL), edgeOptions);
//            break;
//
//        default:
//            throw new RuntimeException("Browser not supported: " + br);
//    }
//
//    logger.info("************* Remote WebDriver Launched in Headless Mode *****************");
//    driver.manage().window().maximize();
//}
//
//
//
//
////    chnages for running multiple scenarios
////    This Script Run For Clicking The Side Menu Masters
//
//
//
//
//@Before(order = 0)
//public void loadProperties() throws IOException {
//    // Load config.properties
//    configprop = new Properties();
//    String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
//    FileInputStream configProfile = new FileInputStream(configPath);
//    configprop.load(configProfile);
//
//    // Logger setup
//    logger = Logger.getLogger("MaterialManagementSharePointApplication");
//    String log4jPath = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
//    PropertyConfigurator.configure(log4jPath);
//    logger.setLevel(Level.DEBUG);
//}
//@Before(order = 1)
//public void launchBrowser() throws MalformedURLException {
//    String br = configprop.getProperty("browser");
//    String hubURL = configprop.getProperty("hubURL");
//
//    switch (br.toLowerCase()) {
//        case "chrome":
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless=new"); // Use new headless mode
//            chromeOptions.addArguments("--no-sandbox");
//            chromeOptions.addArguments("--disable-dev-shm-usage");
//            chromeOptions.addArguments("--disable-gpu");
//            chromeOptions.addArguments("--remote-allow-origins=*");
//            chromeOptions.addArguments("--window-size=1920,1080"); // Use comma instead of x
//            chromeOptions.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
//            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
//            chromeOptions.addArguments("--exclude-switches=enable-automation");
//            chromeOptions.addArguments("--disable-web-security");
//            chromeOptions.addArguments("--allow-running-insecure-content");
//            chromeOptions.addArguments("--disable-features=VizDisplayCompositor");
//
//            // Set experimental options for better headless behavior
//            chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//            chromeOptions.setExperimentalOption("useAutomationExtension", false);
//
//            driver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
//            break;
//
//        case "firefox":
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.addArguments("--headless");
//            firefoxOptions.addArguments("--no-sandbox");
//            firefoxOptions.addArguments("--disable-dev-shm-usage");
//            firefoxOptions.addArguments("--width=1920");
//            firefoxOptions.addArguments("--height=1080");
//            driver = new RemoteWebDriver(new URL(hubURL), firefoxOptions);
//            break;
//
//        default:
//            throw new RuntimeException("Browser not supported: " + br);
//    }
//
//    // Set timeouts explicitly for remote driver
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
//
//    logger.info("Browser launched in headless mode with enhanced options");
//}
//    @After(order = 0)
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            // Take screenshot
//            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }
//    }
//
//    @After(order = 1)
//    public void quitBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }











}
