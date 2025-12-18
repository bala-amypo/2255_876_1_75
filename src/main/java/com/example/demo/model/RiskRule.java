    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ruleName;
    private String ruleType;
    private int threshold;
    private int scoreImpact;
    private LocalTimeDate 