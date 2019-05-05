public enum ExpenseType {
  FUNDRAISING,
  FOOD,
  CLOTHING,
  MEDICAL_SUPPLIES,
  EVENTS;

  @Override
  public String toString() {
    switch (this) {
      case FUNDRAISING:
        return "FUNDRAISING";
      case FOOD:
        return "FOOD";
      case CLOTHING:
        return "CLOTHING";
      case MEDICAL_SUPPLIES:
        return "MEDICAL_SUPPLIES";
      case EVENTS:
        return "EVENTS";
      default: throw new IllegalArgumentException();
    }
  }
}

