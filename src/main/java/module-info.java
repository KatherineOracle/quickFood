module kv.hyperiondev.java.quickfood {
	requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
	requires java.logging;
	requires java.base;
	requires java.net.http;
    opens kv.hyperiondev.java.quickfood to javafx.fxml;
    exports kv.hyperiondev.java.quickfood;
}
