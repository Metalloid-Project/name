# @Name annotation for WebElements and Controls


This library allows you to annotate `WebElement`s and `Control`s with `@Name` annotation which accepts `String` as an argument.

## Examples:

### WebElement
```
@Name(description = "This is a name of element")
@FindBy(id = "button")
WebElement element;
```
### Control
```
@Name(description = "This is a name of control")
@FindBy(id = "button")
Button button;
```

There are two possible usages. As a standalone library or as a part of *Metalloid Core*

### Standalone
In order to be able to access the `@Name` annotation, you need to store those, invoking the `store(Object pageObject)` method from `NameStore.class`
Example:
```
public class PageObject {

    @Name(description = "This is a name of element")
    @FindBy(id = "button")
    WebElement element;

    @Name(description = "This is a name of control")
    @FindBy(id = "button")
    Button button;

    public PageObject() {
        NameStore.store(this);
    }
}
```

Then you can read the `@Name` like this:
```
public class PageObject {

    @Name(description = "This is a name of element")
    @FindBy(id = "button")
    WebElement element;

    @Name(description = "This is a name of control")
    @FindBy(id = "button")
    Button button;

    public PageObject() {
        NameStore.store(this);
        //read from WebElement
        System.out.println(NameStore.getDescription(element));
        //read from Control
        System.out.println(NameStore.getDescription(button));
    }
}
```

### With Metalloid Core
Metalloid Core saves descriptions of WebElements/Controls with `Metalloid.initialize(Object pageObject)` method.
To read the description just use 
`NameStore.getDescription()` and provide `WebElement` or `Control` as an argument
