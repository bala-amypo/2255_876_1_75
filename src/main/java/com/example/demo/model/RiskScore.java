    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;
    @ManyToOne
    @JoinColumn(name = "riskrule_id", nullable = false)
    private RiskRule appliesRule;
    private int scoreChange;
    private String reason;
    private LocalDateTime loggetAt;